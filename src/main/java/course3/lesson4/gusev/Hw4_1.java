package course3.lesson4.gusev;

import java.util.concurrent.atomic.AtomicReference;

public class Hw4_1 {
    private final Object mon = new Object();
    private AtomicReference<Character> currentLetter = new AtomicReference<>('A');

    public static void main(String[] args) {
        Hw4_1 hw4_1 = new Hw4_1();

        Thread thread1 = new Thread(()-> hw4_1.printSymb('A', 'B'));
        Thread thread2 = new Thread(()-> hw4_1.printSymb('B', 'C'));
        Thread thread3 = new Thread(()-> hw4_1.printSymb('C', 'A'));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void printSymb(char symb, char nextSymb) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter.get() != symb) {
                        mon.wait();
                    }
                    System.out.print(symb);
                    currentLetter.set(nextSymb);
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

