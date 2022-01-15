package course1.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskApp {
    //задача
    // дан массив целых чисел, требуется удалить все не уникальные значения кроме последнего
    // [3, 4, 5, 3, 5, 6] -> [4, 3, 5, 6]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNewArray(new int[]{3, 4, 5, 3, 5, 6})));
    }

    public static int[] getNewArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }



}
