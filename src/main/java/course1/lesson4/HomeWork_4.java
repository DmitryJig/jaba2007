package course1.lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_4 {

    //поле
    public static char[][] map;

    //размер поля любое целое положительное число
    public static final int SIZE = 5;

    //точек для победы любое целое положительное число меньшее или равно SIZE
    public static final int DOTS_TO_WIN = 4;

    //описание точек
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    //Сканнер
    public static final Scanner SCANNER = new Scanner(System.in);

    //Рандом
    public static final Random RANDOM = new Random();

    /**
     * Инициализируем поле map значениями DOT_EMPTY
     */
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Вывод игрового поля на экран
     */
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * ход человека
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        System.out.println("Вы сходили в точку " + (x + 1) + " " + (y + 1));
    }

    /**
     * ход робота
     */
    public static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Робот делает ход в " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }

    /**
     * проверка валидны ли значения поля
     *
     * @param x координата х
     * @param y координата у
     * @return да если сходить можно, нет если место занято или за пределами поля
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    /**
     * Проверка победы
     * @param symbol символ для которого проверяем крестик или нолик
     * @return true если выиграл
     */
    public static boolean checkWin(char symbol) {

        //проверяем строки и колонки
        for (int i = 0; i < SIZE; i++) {
            int dotCountX = 0;
            int dotCountY = 0;
            for (int j = 0; j < SIZE; j++) {
                dotCountX = map[i][j] == symbol ? ++dotCountX : 0;
                dotCountY = map[j][i] == symbol ? ++dotCountY : 0;
                if (dotCountX >= DOTS_TO_WIN || dotCountY >= DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        // диагональ слева направо сверху вниз

        int countPositions = SIZE - DOTS_TO_WIN + 1; // количество линий, по которым можно выиграть на одной оси

        for (int startPos = 0; startPos < countPositions; startPos++) { // стартовая позиция счетчика
            int j = 0;
            int dotCount1 = 0; // счетчик точек слева направо сверху вниз на диагонали и ниже
            int dotCount2 = 0; // счетчик точек слева направо сверху вниз на диагонали и выше
            for (int i = startPos; i < SIZE; i++) {
                dotCount1 = map[i][j] == symbol ? ++dotCount1 : 0;
                dotCount2 = map[j][i] == symbol ? ++dotCount2 : 0;
                if (dotCount1 >= DOTS_TO_WIN || dotCount2 >= DOTS_TO_WIN) {
                    return true;
                }
                j++;
            }

        }

        // диагональ слева направо снизу вверх

        for (int startPos = SIZE - 1; startPos >= (SIZE - countPositions); startPos--) {
            int j = 0;
            int dotCount1 = 0;
            int dotCount2 = 0;
            for (int i = startPos; i >= 0; i--) {
                dotCount1 = map[i][j] == symbol ? ++dotCount1 : 0;
                dotCount2 = map[SIZE - j - 1][SIZE - i - 1] == symbol ? ++dotCount2 : 0;
                if (dotCount1 >= DOTS_TO_WIN || dotCount2 >= DOTS_TO_WIN) {
                    return true;
                }
                j++;
            }
        }

        return false;
    }

    /**
     * Проверка что в поле не осталось ни одной свободной ячейки
     *
     * @return true если нет ни одной свободной
     */
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Побеждает человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_0)) {
                System.out.println("Робот выиграл");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Game over");
    }
}
