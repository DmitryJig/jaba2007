package course1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApp extends JFrame {
    private  int value;

    public CounterApp(int initialValue){
        setBounds(300, 300, 300, 300);
        setTitle("SimpleCounter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 32);

        JLabel counterValueYiew = new JLabel();
        counterValueYiew.setFont(font);
        counterValueYiew.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueYiew, BorderLayout.CENTER);

        value = initialValue;
        counterValueYiew.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                counterValueYiew.setText(String.valueOf(value));
            }
        });

        incrementButton.addActionListener(e -> {
            value++;
            counterValueYiew.setText(String.valueOf(value));
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterApp(0);
    }
}
