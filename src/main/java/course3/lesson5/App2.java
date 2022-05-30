package course3.lesson5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App2 {
    public static void main(String[] args) {

        // используется вместо синхронизированных блоков, лок можетиспользоваться несколькими потоками,
        // когда лок залочен и второй поток хочет использовать ресурс он пишет лок.лок и блокируется
        // пока первый поток не скажет unlock
        final ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try{
            //
        } finally {
            lock.unlock();
        }
        lock.tryLock(); // возвращает тру если получилось взять лок
        lock.unlock();
        try {
            lock.tryLock(1000, TimeUnit.SECONDS); // можем передать таймаут на ожидание доступа к ресурсу
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        // тут 2 лока, на чтение и на запись
        // readlock если не один поток не пишет любое число потоков может читать (если не взят лок на запись)
//         writelock если не один поток не читает то один поток может писать
        final ReentrantReadWriteLock lock2 = new ReentrantReadWriteLock();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                lock2.readLock().lock(); // другие потоки могут читать
                try{
                    System.out.println("Начало чтения " + finalI);
                    Thread.sleep(1000);
                    System.out.println("Закончили читать " + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.readLock().unlock();
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(()->{
                lock2.writeLock().lock(); // когда один поток начинает запись второй ждет пока первый не закончит
                try{
                    System.out.println("Начало записи " + finalI);
                    Thread.sleep(1000);
                    System.out.println("Конец записи " + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.writeLock().unlock();
                }
            }).start();
        }
    }
}
