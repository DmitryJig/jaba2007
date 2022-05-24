package course3.lesson5.gusev;

import java.util.concurrent.Semaphore;

/**
 * Стандартные классы синхронизации
 * семафор разрешает доступ к объекту определенному числу потоков
 */
public class SemaphoreApp {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2); // два потока могут одновременно обращаться к ресурсу
        for (int i = 0; i < 10; i++) {
            final int w = i + 1;
            new Thread(()->{
                try{
                    System.out.println("Поток " + w + " перед семафором");
                    semaphore.acquire();        // we can write here permits(count) for big thread
                    System.out.println("Поток " + w + " получил доступ к ресурсу");
                    Thread.sleep(500);
                } catch (Exception ex){

                } finally {
                    System.out.println("Поток " + w + " отпустил ресурс");
                    semaphore.release();
                }
            }).start();
        }
    }
}
