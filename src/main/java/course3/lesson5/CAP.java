package course3.lesson5;

import java.util.concurrent.ArrayBlockingQueue;

// consumer - producer один потребляет данные, другой производит
public class CAP {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(6);
        new Thread(() -> {
            final Producer producer = new Producer(queue);
            for (int i = 0; i < 12; i++) {
                producer.put(String.valueOf(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            final Consumer consumer = new Consumer(queue);
            for (int i = 0; i < 12; i++) {
                consumer.get();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}

class Producer {

    // очередь имеет емкость, когда ее создаем надо ее передать
    // когда кладем в нее данные больше она вместить не может метод put заблокируется
    // и будет ожидать пока данные кто нибудь вычитает
    private final ArrayBlockingQueue<String> queue;

    public Producer(ArrayBlockingQueue<String> queue) {  // коллекция блокируется порка из нее не вычитать сообщение
        this.queue = queue;
    }

    public void put(String x) {
        System.out.println("Produccer add " + x);
        try {
            queue.put(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private final ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public String get() {
        try {
            final String take = queue.take(); // если данных в очереди нет то тут блокируемся и ждем
            System.out.println("Consumer get " + take);
            return take;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
