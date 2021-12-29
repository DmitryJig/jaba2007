package course1.lesson3;

public class LogicApp {
    public static void main(String[] args) {
//        or ||  |
//        and && &
//        not !
        int a = 10;
        if (isPositive(a) && !isZero(a)) {
            System.out.println("положительно и не 0 ");
        }
    }

    public static boolean isPositive(int val) {
        return val >= 0;
    }

    public static boolean isZero(int val) {
        return val == 0;
    }
}
