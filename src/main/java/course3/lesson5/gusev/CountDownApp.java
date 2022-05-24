package course3.lesson5.gusev;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Защелка, ожидаем что сколько то потоков будет готовы, тогда оно выполнится
 * синхронизируем несколько потоков в одной точке
 * !!! 2 раза один каунтдаун не используется
 */
public class CountDownApp {

    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5); // we must wait 5 threads
        for (int i = 0; i < 5; i++) {
            int w = i+1;
            new Thread(()->{
                try {
                    // task
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println("Поток "+ w + " is ready");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // wait everybody in main thread

        countDownLatch.await();

        System.out.println("work complete");
    }
}
