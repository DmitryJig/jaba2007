package course3.lesson5;

import java.util.concurrent.Semaphore;

public class App03Semaphore {

    public static void main(String[] args) {

        // Если число потоков больше критического доступ к объекту блокируется
        final Semaphore semaphore = new Semaphore(4);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    semaphore.acquire(); // если более критического числа потоков сказали acuire доступ блокируется пока место не освободится
                    System.out.println("Поток " + Thread.currentThread().getName() + " выполняет долгую работу");
                    Thread.sleep(1000);
                    System.out.println("Поток " + Thread.currentThread().getName() + " закончил работу");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // освобождаем место в семафоре чтобы другие потоки могли воспользоваться ресурсом
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
//        try{
//            semaphore.acquire(); // говорит я вошел
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        semaphore.release(); // говорит я вышел
    }


}
