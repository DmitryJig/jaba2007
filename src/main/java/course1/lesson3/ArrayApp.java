package course1.lesson3;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        int[] array = new int[5];
//    int[] array2 = array;
        array[2] = 199;
        array[array.length - 1] = 100;

        for (int i = 0; i < array.length; i++) {
            array[i] = 100 + i*100;
        }

        int[] arr = {1, 2, 3, 4, 5};
        printArray(array);
        printArray(arr);

        String[] strings = new String[10];

        Arrays.fill(strings, "a");
        System.out.println(Arrays.toString(strings));

        boolean[] booleans = {};
        System.out.println(Arrays.toString(booleans));
    }

    public static void method1 (int a) {
        a = a + 10;
    }

    public static void method2(int[] a) {
        a[2] = 100;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
