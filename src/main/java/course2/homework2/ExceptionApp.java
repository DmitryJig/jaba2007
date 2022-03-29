package course2.homework2;

import java.util.Arrays;

/**
 * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 *
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
 * при условии что подали на вход корректный массив).
 */

public class ExceptionApp {

    public static void main(String[] args) {

        String[][] arr1 = new String[4][4]; // хороший массив
        String[][] arr2 = new String[5][5]; // Массив не соответствующий формату
        String[][] arr3 = new String[4][4]; // сюда воткнем букву вместо цифры
        for (String[] str : arr1) {
            Arrays.fill(str, "1");
        }
        for (String[] str : arr2) {
            Arrays.fill(str, "1");
        }
        for (String[] str : arr3) {
            Arrays.fill(str, "1");
        }
        arr3[1][1] = "f";

        //вызываем метод у массивов по очереди
        try {
            System.out.println(getSumFromArray(arr1));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getSumFromArray(arr2));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        try {
            int result = getSumFromArray(arr3);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод возвращает сумму чисел из входящего массива
     * @param inputArray входящий массив
     * @return сумма элементов массива
     * @throws MyArraySizeException ошибка размера массива
     * @throws MyArrayDataException ошибка значения в ячейке массива
     */
    public static int getSumFromArray(String[][] inputArray) throws MyArraySizeException, MyArrayDataException {
        if (!(inputArray.length == 4)) {
            throw new MyArraySizeException("Неверный формат массива");
        }
        for (int i = 0; i < inputArray.length; i++) {
            if (!(inputArray[i].length == 4)) {
                throw new MyArraySizeException("Неверный формат массива");
            }
        }
        int result = 0;
        int[] coord = new int[2];
        try {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                    coord[0] = i;
                    coord[1] = j;
                    result += Integer.parseInt(inputArray[i][j]);
            }
        }
        } catch (NumberFormatException e){
            throw  new MyArrayDataException("Неверное значение в ячейке " + coord[0] + " " + coord[1]);
        }
        return result;
    }


}
