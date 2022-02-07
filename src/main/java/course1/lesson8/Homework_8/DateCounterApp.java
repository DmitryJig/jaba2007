package course1.lesson8.Homework_8;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Программа представляет тот же счетчик, только добавлены:
 * стрелки ">>" и "<<" которыми к значению "value" прибавляется и вычитается 10
 * показывает текущую дату и дату и день недели через "value" дней
 */

public class DateCounterApp extends JFrame {
    private int value;
    private LocalDate date = LocalDate.now();
    private JLabel currentDateView;
    private JLabel counterValueView;
    private JLabel newDateView;

    public DateCounterApp(int initialValue) {
        setBounds(300, 300, 500, 300);
        setTitle("Date counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 32);

        currentDateView = new JLabel(dateToString(this.date));
        currentDateView.setFont(font);
        currentDateView.setHorizontalAlignment(SwingConstants.CENTER);
        currentDateView.setBounds(10, 10, 480, 70);
        add(currentDateView);

        counterValueView = new JLabel();
        counterValueView.setFont(font);
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        counterValueView.setBounds(170, 90, 150, 70);
        add(counterValueView);

        value = initialValue;
        counterValueView.setText(String.valueOf(value));

        JButton decDecrementButton = new JButton("<<");
        decDecrementButton.setFont(font);
        decDecrementButton.setBounds(10, 90, 80, 70);
        add(decDecrementButton);

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        decrementButton.setBounds(90, 90, 80, 70);
        add(decrementButton);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        incrementButton.setBounds(320, 90, 80, 70);
        add(incrementButton);

        JButton decIncrementButton = new JButton(">>");
        decIncrementButton.setFont(font);
        decIncrementButton.setBounds(400, 90, 80, 70);
        add(decIncrementButton);

        newDateView = new JLabel(dateToString(getNewDate()));
        newDateView.setFont(font);
        newDateView.setHorizontalAlignment(SwingConstants.CENTER);
        newDateView.setBounds(10, 170, 480, 70);
        add(newDateView);

        decDecrementButton.addActionListener(e -> {
            value -= 10;
            setLabels();
        });

        decrementButton.addActionListener(e -> {
            value--;
            setLabels();
        });

        incrementButton.addActionListener(e -> {
            value++;
            setLabels();
        });

        decIncrementButton.addActionListener(e -> {
            value += 10;
            setLabels();
        });

        setVisible(true);
    }

    /**
     * Переводит дату из формата LocalDate в строку
     *
     * @param date входящее значение даты
     * @return строковое значение даты и дня недели в формате "дд.мм.гггг день недели"
     */
    public String dateToString(LocalDate date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return String.format("%02d.%02d.%d %s", dayOfMonth, month, year, dayOfWeek);
    }

    /**
     * Высчитывает дату через "values" дней от текущей даты
     *
     * @return новая дата
     */
    public LocalDate getNewDate() {
        return this.date.plusDays(value);
    }

    /**
     * Устанавливает новые значения полям
     */
    public void setLabels() {
        counterValueView.setText(String.valueOf(value));
        newDateView.setText(dateToString(getNewDate()));
    }

    public static void main(String[] args) {
        new DateCounterApp(-2);
    }
}
