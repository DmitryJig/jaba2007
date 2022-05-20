package course3.lesson4.gusev;

/**
 * Если методы запустятся по порядку то норм, если нет то дедлок
 */
public class App4 {

    private static final Object mon = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (mon) {
                try {
                    System.out.println("1-1");
                    mon.wait();     // освобождает монитор приостанавливая поток на этом месте, второй поток запускается
                    System.out.println("1-2");
                    mon.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (mon) {
                try {
                    System.out.println("2-1");
                    mon.notify();
                    mon.wait();
                    System.out.println((2 - 2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
