package course1.lesson5;

public class DemoApp {

    public static void main(String[] args) {
        Car car = new Car();
        car.model = "Doge";
        car.year = 2020;

        System.out.println("Model = " + car.model + " Year = " + car.year);

        Car car2 = new Car();
        car2.model = "Ford";
        car2.year = 1990;

        System.out.println("Model = " + car2.model + " Year = " + car2.year);
        Car[] cars = new Car[]{car, car2};
    }
}
