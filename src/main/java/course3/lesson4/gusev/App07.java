package course3.lesson4.gusev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App07 {
    public static void main(String[] args) {
//        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 10_000; i++) {
            System.out.println(i);
            executorService.execute(()->{

                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown(); // выключить(если процесс зациклен то не поможет)
        try {
            if (executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
