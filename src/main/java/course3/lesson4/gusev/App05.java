package course3.lesson4.gusev;

public class App05 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            while (!Thread.interrupted()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); // можно написать break
                }
                if (1 == 0){
                    break;
                }
            }
            System.out.println("Закрываем ресурсы");
        });
        thread1.start();
//        thread1.stop(); // низзя!!! закроет все нафиг!!!

        thread1.interrupt(); // поток остановится если он wait or sleep, если он крутится и в потоке вычисления то ничего просто так не остановится
    }
}
