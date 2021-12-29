package course1.lesson2;

public class CristmasTree {
    public static void christmasTree() {
        int width = 17;
        for (int x = 0; x < 3; x++) {
            int height = 2 * x + 3;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == width / 2 + i + x || j == width / 2 - i - x || (i == height - 1 && (j > width / 2 - i - x && j < width / 2 + i + x))) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }
        }
    }
}
