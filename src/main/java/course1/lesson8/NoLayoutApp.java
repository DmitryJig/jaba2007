package course1.lesson8;

import javax.swing.*;

public class NoLayoutApp extends JFrame {
    public NoLayoutApp(){
        setBounds(300, 300, 300, 300);
        setTitle("ManualGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        JTextField field = new JTextField();
        field.setBounds(20, 20, 120, 32);
        add(field);
        JButton button = new JButton("Press here");
        button.setBounds(20, 60, 120, 32);
        add(button);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoLayoutApp();
    }
}
