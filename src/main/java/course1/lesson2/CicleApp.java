package course1.lesson2;

public class CicleApp {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {

            if (i % 2 == 0) {
                continue;
            }
            if (1 > 6) {
                break;
            }
                PrintUtil.printFormatted("string" + i);
        }
        System.out.println(getDividedByThree());

        chess();
        usFlag();
    }

    public static int getDividedByThree() {
        for (int i = 2; i < 10; i = i+2) {
            if (i % 3 == 0) {
                return i;
            }
        }
        return 0;
    }

    public static void chess() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void usFlag() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i>4 || j > 5) {
                    System.out.print("0 ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
