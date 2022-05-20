package course3.lesson5;

import java.util.concurrent.ArrayBlockingQueue;

// consumer - producer
public class CAP {



}

class Producer {
    private final ArrayBlockingQueue<String> queue;

    public Producer(ArrayBlockingQueue<String> queue) {  // коллекция блокируется порка из нее не вычитать сообщение
        this.queue = queue;
    }
}

class Consumer {

}
