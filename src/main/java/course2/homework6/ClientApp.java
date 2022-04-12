package course2.homework6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp extends JFrame {

    private final String SERVER_ADRESS = "localhost";
    private final int SERVER_PORT = 8089;

    private JTextField textField;
    private JTextArea textArea;

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientApp() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareUI();
    }

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADRESS, SERVER_PORT);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try{
                while (true){
                    String messageFromServer = dataInputStream.readUTF();
                    if ("/end".equals(messageFromServer)){
                        System.out.println("Клиент завершает работу");
                        break;
                    }
                    textArea.append("server: " + messageFromServer);
                    textArea.append("\n");
                }
                textArea.append("Соединение разорвано");
                textField.setEditable(false);
                closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void closeConnection() {
        try{
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            socket.close();  //сокет закрываем последним потому что два предыдущих потока открыты из сокета
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(){
        if(textField.getText().trim().isEmpty()){
            return;
        }

        try{
            textArea.append("my message: " + textField.getText() + "\n");
            dataOutputStream.writeUTF(textField.getText());
            textField.setText("");
            textField.grabFocus();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void prepareUI() {
        setBounds(200, 200, 500, 500);
        setTitle("EchoClient");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        JButton button = new JButton("Send");
        panel.add(button, BorderLayout.EAST);
        textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientApp());
    }
}