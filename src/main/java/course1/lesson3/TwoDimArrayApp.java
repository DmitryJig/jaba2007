package course1.lesson3;

import java.util.Arrays;

public class TwoDimArrayApp {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        System.out.println(Arrays.toString(array));

        int[] subArray = array[2];
        System.out.println(Arrays.toString(subArray));


        int[][] newArray = new int[5][];

        newArray[0] = new int[]{1,2,3};
        System.out.println(Arrays.toString(newArray));
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(Arrays.toString(newArray[i]));
        }

        int[][] arr = {{1,2}, {3,4}, {5, 6, 7}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
