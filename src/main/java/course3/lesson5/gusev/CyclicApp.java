package course3.lesson5.gusev;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Циклический барьер
 */
public class CyclicApp {

    private static Random random = new Random();

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        for (int i = 0; i < 5; i++) {
            int w = i + 1;
            new Thread(()->{

                try {
                    System.out.println(w + " готовится");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println(w + " ready");
                    cyclicBarrier.await(); // ожидает пока в одной точке соберется нужное количество потоков

                    System.out.println(w + " started");
                    Thread.sleep(random.nextInt(5) * 1000);
                    System.out.println(w + " finished");
                    cyclicBarrier.await();

                    System.out.println("Гонка закончилась");

                } catch (InterruptedException e) {
                    // ignore
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
