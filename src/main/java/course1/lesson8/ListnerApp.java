package course1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Вешаем слушателя на кнопку
 */
public class ListnerApp extends JFrame {
    private JTextField textField = new JTextField();
    private JButton button = new JButton("Press here");

    public  ListnerApp() {
        setBounds(300,300,300,300);
        setTitle("Listner Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closed");
            }
        });

        setLayout(null);

        button.setBounds(20, 20, 120, 50);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("Pressed");
                System.out.println(textField.getText());
            }
        });

        textField.setBounds(20, 90, 120, 32);
        add(textField);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText()
                );
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListnerApp();
    }
}
