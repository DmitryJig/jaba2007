package course1.lesson2;

import java.util.Timer;

public class Gipnoz {
    public static void main(String[] args) throws InterruptedException {
        gipnoz();
    }

    public static void gipnoz() throws InterruptedException {
        int width = 9;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < width; j++) {
                if (j == i % width || j == width - i % width-1) {
                    System.out.print("* ");
                } else System.out.print("  ");
            }
            System.out.println();
            Thread.sleep(100);
        }
    }
}
