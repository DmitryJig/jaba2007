package course1.lesson2;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println(checkInterval(5, 6));
        printNegativeOrPositive(-10);
        System.out.println(getIsNegative(5));
        printStrings("Я блин выучу эту Java", 10);
        System.out.println("0 " + checkYear(0));
        System.out.println("400 " + checkYear(400));
        System.out.println("100 " + checkYear(100));
        System.out.println("2000 " + checkYear(2000));
        System.out.println("2004 " + checkYear(2004));
    }

    //  1. метод проверяет лежит ли сумма чисел в интервале от 10 до 20 включительно
    public static boolean checkInterval(int x, int y) {
        int b = x + y;
        return b >= 10 && b <= 20;
    }

    //  2. метод принимает целое число и печатает в консоль положительное число или отрицательное
    public static void printNegativeOrPositive(int i) {
        if (i < 0) {
            System.out.println("Число " + i + " отрицательное");
        } else {
            System.out.println("Число " + i + " положительное");
        }
    }

    //  3. метод принимает целое число, если оно отрицательное возвращается true иначе false
    public static boolean getIsNegative(int x) {
        return x < 0;
    }

    //  4. метод принимает строку и число, и печатает в консоль указанную строку указанное количество раз
    public static void printStrings(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    //  5. Метод определяет является ли год високосным, возвращает true если да, false если нет
    public static boolean checkYear(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            }
            return true;
        }
        return false;
    }
}
