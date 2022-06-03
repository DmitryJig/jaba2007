package course3.lesson6.gusev;

public class Calculator {

    private Battery battery;

    public Calculator() {
        battery = new Battery(100);
    }

    public Calculator(Battery battery) {
        this.battery = battery;
    }

    public int sum(int a, int b) {
        return a + b;
//        return a + b + 1; // так в тесте вылезет ошибка с сообщением которое добавили в assertions
    }

    public int multiply(int a, int b) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * b; // пытаемся воспроизвести баг
    }

    public int division(int a, int b){

        return a / b;
    }
}
