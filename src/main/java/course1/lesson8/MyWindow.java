package course1.lesson8;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window"); // устанавливает заголовок
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
//        JButton button = new JButton("Simple Button 1"); // в этом блоке при помощи компоновщика располагаем кнопик вверху и внизу
//        JButton button2 = new JButton("Simple Button 2");
//        add(button, BorderLayout.NORTH);
//        add(button2, BorderLayout.SOUTH);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        for (int i = 1; i <= 10; i++) {
            add(new JButton("#" + i));
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
