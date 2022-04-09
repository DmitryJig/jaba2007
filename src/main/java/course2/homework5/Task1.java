package course2.homework5;

import java.util.Arrays;

/**
 * Домашняя работа
 */

public class Task1 {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    /**
     * метод без деления массива
     */
    public static void method1(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Метод без разбиения массивов массивов " + (System.currentTimeMillis() - a) + " ms");
    }

    /**
     * Метод с делением массива
     */
    public static void method2(){
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        float[] leftHalf= new float[HALF];
        float[] rightHalf = new float[HALF];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        System.arraycopy(leftHalf, 0, arr, 0, HALF);
        System.arraycopy(rightHalf, 0, arr, HALF, HALF);
        System.out.println("Метод с разбиением массивов " + (System.currentTimeMillis() - a) + " ms");
    }

    /**
     *Вызываем оба метода
     */
    public static void main(String[] args) {
        method1();
        method2();
    }
}
