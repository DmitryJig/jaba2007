package course3.lesson4.gusev;

import java.util.concurrent.*;

public class ExecutorApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // один поток
//        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        ExecutorService executorService = Executors.newScheduledThreadPool(5); // может запускать потоки по расписанию

        ExecutorService executorService = Executors.newCachedThreadPool(); // типа резиновый
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        Future<?> future = executorService.submit(() -> System.out.println("smth"));

        Future<String> stringFuture = executorService.submit(new MyCallable());

        System.out.println(stringFuture.get());

        future.get(); // гет как джойн у обычного треда
        executorService.shutdown(); // не принимает новых задач но заканчивает обработку старых
        executorService.shutdownNow(); // завершить здесь и сейчас, всем рабочим задачам рассылает интеррапты
    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "string from callable";
        }
    }
}
