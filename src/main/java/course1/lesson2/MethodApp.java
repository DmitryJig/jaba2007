package course1.lesson2;

public class MethodApp {
    public static void main(String[] args) {

        int v1 = multiplication(4, 10);
        int v2 = multiplication(5, 6);
        int v3 = multiplication(v1, v2);
        System.out.println(multiplication(v1, v2));

        PrintUtil.printFormatted("string to format");
    }

    public static int multiplication(int n1, int n2) {
        return n1 * n2;
    }
}
