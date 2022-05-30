package course3.lesson5;

import java.util.concurrent.CountDownLatch;

public class App4CDL {
    public static void main(String[] args) {
        // !!! Если количество укажем 5 а вызов каунтдауна только 4 то мы никогда не разблокируемся,
        // меньше можно, тогда можем не дождаться выполнения работы последнего потока
        final CountDownLatch cdl = new CountDownLatch(4); // Ждем пока все выполнят работу (одноразовая штука)
//        cdl.countDown();
//        cdl.countDown();
//        cdl.countDown();
//        cdl.countDown();

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " начинает выполнять работу");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " закончил выполнять работу");
                    cdl.countDown(); // 4 раза выполняем эту команду, только после нее основной поток стартует после команды await
                }
            }).start();
        }
        try {
            System.out.println("Блокируемся");
            cdl.await(); // блокируемся пока 4 раза не будет countdown, причем где угодно
            System.out.println("Поехали дальше!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
