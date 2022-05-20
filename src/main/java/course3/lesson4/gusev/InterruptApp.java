package course3.lesson4.gusev;

public class InterruptApp {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{

            for (int i = 0; i < 5; i++) {
                if (Thread.currentThread().isInterrupted()){
                    break;
                }
                System.out.println(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    isInterrupted = true;
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();
        Thread.sleep(1000);
//        thread.stop(); // использовать нельзя, убивает поток мнгновенно
        thread.interrupt();
    }
}
