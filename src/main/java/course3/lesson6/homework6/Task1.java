package course3.lesson6.homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Task1 {

    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный
     * целочисленный массив. Метод должен вернуть новый массив, который получен путем
     * вытаскивания из исходного массива элементов, идущих после последней четверки. Входной
     * массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
     * RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */

    public int[] getNumbersAfterLastNumber(int[] array, int number){
        int positionAfterNumber = -1;
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            if (array[i] == number){
                positionAfterNumber = i + 1;
            }
        }
        if (positionAfterNumber == -1){
            throw new RuntimeException("Массив не содержит число 4");
        }
        int[] result = new int[len - positionAfterNumber];
        int counter = 0;
        for (int j = positionAfterNumber; j < len; j++) {
            result[counter] = array[j];
            counter++;
        }
        return result;
    }

    public boolean checkAvailable1And4(int[] array, int num1, int num2){
        List<Integer> list = IntStream.of(array).boxed().toList();
        if(list.stream().anyMatch(x -> x != num1 || x!= num2) ){
            return false;
        }
        if (list)
        return false;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        int[] array = {1, 2, 3, 4};
        System.out.println(task1.checkAvailable1And4(array));
    }
}
