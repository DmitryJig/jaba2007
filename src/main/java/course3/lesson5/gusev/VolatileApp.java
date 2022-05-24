package course3.lesson5.gusev;

/**
 * тут мы обращаемся к одной переменной из разных потоков
 * возможна проблема если процессор закэширует переменные в разные ядра, для этого используем volatile
 * запись происходит перед чтением, освобождение ресурса произойдет перед тем как его захватит другой
 * от условия гонки не спасет но спасет от прочтения старого значения
 */
public class VolatileApp {

    private static volatile boolean isRunning = true;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            while (isRunning) {
                System.out.println("still alive");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread.sleep(2000);
        isRunning = false;
        // на этапе компиляции допишется systemlock, пока запись не завершится чтения не будет
        System.out.println("stop");
    }
}
