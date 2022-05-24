package course3.lesson5.gusev;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * лок можем захватить в одном методе а отпустить в другом
 */
public class LockApp {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(()->{
            try{
                lock.lock();

                // не блокирующий, фозвращает фолс если не смог, можно указать кол-во секунд
                // если через 10 секунд не смог вернет фолс
//                lock.tryLock(10, TimeUnit.SECONDS);

                // критическая секция

                if (!lock.tryLock(10, TimeUnit.SECONDS)){
                    System.out.println("Не удалось захватить блокировку");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // can blocking on read and write
// пока один поток пишет читать нельзя никому, лок на запись нельзя взять пока хоть кто то читает
        readWriteLock.readLock();
    }
}
