package course3.lesson4.gusev;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App08 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        ArrayList<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            tasks.add(() -> "i = " + finalI);
        }

        List<Future<String>> futures = executorService.invokeAll(tasks);

        futures.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

//        final Future<Integer> future = executorService.submit(new C1());
//        try {
//            if (future.isDone()) {
//                Integer integer = future.get(); // блокирующий метод, блокирует поток пока не кончится выполнение задачи
//            } else {

//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        executorService.shutdown();
    }

}

class R implements Runnable {

    @Override
    public void run() {
        int s = 0;
        for (int i = 0; i < 100; i++) {
            s += i;
        }
    }
}

class C1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int s = 0;
        for (int i = 0; i < 100; i++) {
            s += i;
        }
        return s;
    }
}
