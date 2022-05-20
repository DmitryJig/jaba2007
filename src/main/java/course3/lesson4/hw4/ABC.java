package course3.lesson4.hw4;

import java.util.concurrent.atomic.AtomicReference;

public class ABC {

    private final Object mon = new Object();
    private AtomicReference<Character> currentLetter = new AtomicReference<>('A');

    public static void main(String[] args) {
        ABC abc = new ABC();

        Thread thread1 = new Thread(()-> abc.printSymb('A', 'B'));
        Thread thread2 = new Thread(()-> abc.printSymb('B', 'C'));
        Thread thread3 = new Thread(()-> abc.printSymb('C', 'A'));

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
