package course3.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class App01 {

    public static void main(String[] args) {
        // использует Compare and set специальная инструкция процессора
        AtomicInteger i = new AtomicInteger(10);

        int i1 = i.accumulateAndGet(2, (y, x) -> y / x); // передаем значение и функцию
        System.out.println(i1); // 5
        i1 = i.incrementAndGet();

        AtomicReference atomicReference = new AtomicReference(new Object()); // передаем объект и все операции с ним будут  изолированы от других потоков

        // get synchronized version arraylist
        List<String> objects = Collections.synchronizedList(new ArrayList<>()); // тоже устаревший способ

        // каждый раз создается копия объекта и в разных потоках они могут работать независимо
       final  List<Integer> objects1 = new CopyOnWriteArrayList<>(); // позволяет удалять из самого себя в цикле

        objects1.add(1);
        objects1.add(2);
        for (Integer integer: objects1) {
            objects1.remove(integer);
        }

        ConcurrentHashMap<Integer, String> integerStringConcurrentHashMap = new ConcurrentHashMap<>(); // блокируется только бакет а не вся коллекция


    }
}
