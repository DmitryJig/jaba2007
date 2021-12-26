package course1.lesson2;

/**
 * создаем поле 6*6
 */

public class Demo {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j > 2) {
                    System.out.print("0 ");
                } else {
                System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
