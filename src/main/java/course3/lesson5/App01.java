package course3.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class App01 {

    public static void main(String[] args) {

        AtomicInteger i = new AtomicInteger(10);

        int i1 = i.accumulateAndGet(2, (x, y) -> x / y);

        List<String> objects = Collections.synchronizedList(new ArrayList<>()); // тоже устаревший способ

       final  List<Integer> objects1 = new CopyOnWriteArrayList<>(); // позволяет удалять из самого себя в цикле

        objects1.add(1);
        objects1.add(2);
        for (Integer integer: objects1) {
            objects1.remove(integer);
        }

        ConcurrentHashMap<Integer, String> integerStringConcurrentHashMap = new ConcurrentHashMap<>(); // блокируется только бакет а не вся коллекция


    }
}
