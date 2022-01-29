package course1.lesson8;

import javax.swing.*;
import java.awt.*;

/**
 * Раскладывает элементы по равным ячейкам таблицы
 */
public class GridLayoutApp extends JFrame {
    public GridLayoutApp(){
        setBounds(500,500, 400, 300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            add(new JButton(String.valueOf(i + 1)));
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutApp();
    }
}
