package course1.lesson2;

public class figures {

    static int width = 8;
    static int heigth = 8;

    public static void main(String[] args) {
        System.out.println();
        drawFlag();
        System.out.println();
        drawSquare();
        System.out.println();
        drawSquareWithX();
        System.out.println();
        triangle();
        System.out.println();
        CristmasTree.christmasTree();
    }
//  рисуем флаг
    public static void drawFlag() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i > 3 || j > 4) {
                    System.out.print("0 ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
//  draw square
    public static void drawSquare() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == heigth-1 || j == width - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
//    draw square with line
    public static void drawSquareWithX() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == heigth - 1 || j == width - 1
                        || (heigth - i - 1) == j || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
//  рисуем треугольник
    public static void triangle() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == j || j == width - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}


