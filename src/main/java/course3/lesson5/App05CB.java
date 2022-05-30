package course3.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class App05CB {
    public static void main(String[] args) {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);//

//        try {
//            cyclicBarrier.await(); // в этой точке поток блокируется
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{

                try {
                    System.out.println("Подготовка " + Thread.currentThread().getName());
                    Thread.sleep(500);
                    System.out.println("Готов " + Thread.currentThread().getName());
                    // будет заблокирован пока все другие не вызовут await
                    // блокируем все потоки пока остальные не подготовятся
                    cyclicBarrier.await();
                    System.out.println("Поехали " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("Снова поехали " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
