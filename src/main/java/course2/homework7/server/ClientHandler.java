package course2.homework7.server;

import course2.homework7.constants.Constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

/**
 * Обработчик для конкретного клиента
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public ClientHandler(MyServer server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(()->{
                try{
                    autentification();
                    readMessage();
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException e) {
            throw new RuntimeException("Проблема при создании обработчика");
        }

    }


    // /auth login pass
    private void autentification() throws IOException {
        while (true) {
            String str = in.readUTF();
            if (str.startsWith(Constants.AUTH_COMMAND)) {
                String[] tokens = str.split("\\s+"); // получаем массив длинной 3
                Optional<String> nick = server.getAuthService().getNickByLoginAndPass(tokens[1], tokens[2]);

                if(nick.isPresent()) {
                    // авторизовались
                    name = nick.get();
                    sendMessage(Constants.AUTH_COMMAND + " " + nick);
                    server.broadcastMessage(nick + " вошел в чат");
                    server.subscribe(this);
                    return;
                } else {
                    sendMessage("Неверные логин/пароль");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessage() {
        while (true){
            String messasgeFromClient = "";
            try {
                messasgeFromClient = in.readUTF();
            } catch (IOException e) {
                System.out.println(name + " отключился");
                break;
            }
            System.out.println("Сообщение от " + name + ": " + messasgeFromClient);
            if (messasgeFromClient.startsWith(Constants.PRIVATE_MESSAGE_COMMAND)){
                server.sendMessageForOneClient(messasgeFromClient, name);
                continue;
            }
            if (Constants.END_COMMAND.equals(messasgeFromClient)){
                closeConnection();
                break;
            }
            server.broadcastMessage(name + ": " + messasgeFromClient);
        }
    }

    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            in.close();
        } catch (IOException e) {
            // ignore
        }
        try {
            out.close();
        } catch (IOException e) {
            // ignore
        }
        try {
            socket.close();
        } catch (IOException e) {
            // ignore
        }
    }

    public String getName() {
        return name;
    }
}
