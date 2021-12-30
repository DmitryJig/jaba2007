package course1.lesson3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        replaceNumbers();
        fillArray();
        doubleElements();
        fillDiagonal();
        System.out.println(Arrays.toString(getArray(10, 8)));
        minAndMaxElements();
        int[] array1 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] array2 = {1, 1, 1, 2, 1};
        int[] array3 = {1, 5, 2};
        System.out.println(isCentre(array1));
        System.out.println(isCentre(array2));
        System.out.println(isCentre(array3));
        moveElements(array3, 2);
        System.out.println(Arrays.toString(array3));
        moveElements(array3, -2);
        System.out.println(Arrays.toString(array3));
    }

//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void replaceNumbers() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

//    2. Задать пустой целочисленный массив длиной 100.
//    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
//    пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static void doubleElements() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
//    если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
//    то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void fillDiagonal() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || j == array[i].length - i - 1) {
                    array[i][j] = 1;
                }
            }
        }
//      Выводим результат в консоль
        for (int[] line: array) {
            System.out.println(Arrays.toString(line));
        }
    }

//    5. Написать метод, принимающий на вход два аргумента: len и initialValue,
//    и возвращающий одномерный массив типа int длиной len,
//    каждая ячейка которого равна initialValue;

    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

//    6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

    public static void minAndMaxElements() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int element: array) {
            if (element < minElement) {
                minElement = element;
            }
            if (element > maxElement) {
                maxElement = element;
            }
        }
        System.out.println("В массиве " + Arrays.toString(array));
        System.out.println("Минимальный элемент = " + minElement);
        System.out.println("Максимальный элемент = " + maxElement);
    }

//    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//    метод должен вернуть true, если в массиве есть место,
//    в котором сумма левой и правой части массива равны.

    public static boolean isCentre(int[] array) {
        int leftSide = 0;
        int rightSide = 0;
        for (int elem: array) {
            rightSide += elem;
        }
        if (rightSide == 0) { // если сумма всех чисел массива равна нулю то true в нулевой точке
            return true;
        }
        for (int elem: array) {
            leftSide +=elem;
            rightSide -=elem;
            if (leftSide == rightSide) {
                return true;
            }
        }
        return false;
    }

//    8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//    или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
//    Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//    При каком n в какую сторону сдвиг можете выбирать сами.

    public static void moveElements(int[] array, int n) {

        if (n > 0) {                                    // при n положительном
            for (int count = 0; count < n; count++) {
                int memory = array[0];
                for (int i = 0; i < array.length; i++) {
                    int pos = i + 1;
                    if (pos > array.length - 1) {
                        pos = 0;
                    }
                    int number1 = memory;
                    int number2 = array[pos];
                    memory = number2;
                    array[pos] = number1;
                }
            }
        } else if (n < 0) {                         // при n отрицательном
            for (int count = 0; count > n; count--) {
                int memory = array[array.length - 1];
                for (int i = array.length - 1; i >= 0; i--) {
                    int pos = i - 1;
                    if (pos < 0) {
                        pos = array.length - 1;
                    }
                    int number1 = memory;
                    int number2 = array[pos];
                    memory = number2;
                    array[pos] = number1;
                }
            }
        }
    }
}