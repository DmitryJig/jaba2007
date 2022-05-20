package course3.lesson4.gusev;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CounterApp {

    private static class Counter {
        private int value;
        AtomicInteger atomicInteger = new AtomicInteger();

        public Counter() {
            this.value = 0;
        }

        public int getValue() {
            return value;
        }

        public synchronized void increment() { // synchronized
            this.value++;
        }
    }

    private static class DoubleCounter {

        private Object lock1 = new Object(); // два разных объекта для синхронизации
        private Object lock2 = new Object();

        private int first;
        private int second;

        public DoubleCounter() {
            this.first = 0;
            this.second = 0;
        }

        @Override
        public String toString() {
            return "DoubleCounter{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        public void incrementFirst(){
            synchronized (lock1) {
                this.first++;
            }
        }

        public void incrementSecond(){
            synchronized (lock2) {
                this.second++;
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        DoubleCounter doubleCounter = new DoubleCounter();

        AtomicInteger atomicInteger = new AtomicInteger(0); // работает быстрее чем синхронизированный инкремент метод


        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                counter.increment();
                doubleCounter.incrementFirst();
                if(i % 2 == 0){
                    doubleCounter.incrementSecond();
                }


                // в этом случае изменения связаны, блокировка на одном объекте
                synchronized (doubleCounter){
                    doubleCounter.incrementFirst();
                    doubleCounter.incrementSecond();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter.getValue());
        System.out.println(atomicInteger.get());
        System.out.println(doubleCounter.toString());
    }
}
