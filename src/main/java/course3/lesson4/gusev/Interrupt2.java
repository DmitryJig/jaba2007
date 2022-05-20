package course3.lesson4.gusev;

import java.util.concurrent.atomic.AtomicBoolean;

public class Interrupt2 {

    public static void main(String[] args) throws InterruptedException {
        AtomicBoolean isAvailable = new AtomicBoolean(true);
        Thread thread = new Thread(()->{
            while (isAvailable.get()){
                System.out.println("Available");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        isAvailable.set(false);
    }
}
