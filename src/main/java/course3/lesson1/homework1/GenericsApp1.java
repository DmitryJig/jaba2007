package course3.lesson1.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsApp1 {

    public static void main(String[] args) {
        GenericsApp1 genericsApp1 = new GenericsApp1();
        String[] myStrings = new String[]{"ooo", "uuu", "eee"};
        System.out.println(Arrays.toString(genericsApp1.replaceElements(myStrings, 1, 2)));

        System.out.println(genericsApp1.toArrayList(myStrings));
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
     * индексы как в массиве от 0 до
     */

    public <T> T[] replaceElements(T[] array, int index1, int index2) {
        T memory = array[index1];
        array[index1] = array[index2];
        array[index2] = memory;
        return array;
    }

    /**
     * 2. Написать метод, который преобразует массив в ArrayList;
     */
    public <T> List<T> toArrayList(T[] array) {
        List<T> newList = new ArrayList<>();
        for (T elem : array) {
            newList.add(elem);
        }
        return newList;
    }
}
