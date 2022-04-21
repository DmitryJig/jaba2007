package course3.lesson1.gusev;

public class StatsApp {
    public static void main(String[] args) {
        Stats<Integer> integerStats = new Stats<>(1, 2, 3, 4, 5, 6);
        Stats<Integer> integerStats2 = new Stats<>(1, 2, 3, 4, 5, 6);
        Stats<Double> doubleStats = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);

        System.out.println("intStaats avg = " + integerStats.avg());
        System.out.println("doubleStats avg = " + doubleStats.avg());

        if (integerStats.isSaveAvg(integerStats2)) {
            System.out.println("Средние равны");
        } else {
            System.out.println("средние не равны");
        }

        Integer[] arr = new Integer[]{1, 2, 3, 4};
        System.out.println(getAvg(arr));
    }

    // параметризованный метод
    public static <T extends Number> double getAvg(T[] array) {
        return 0;
    }
}
