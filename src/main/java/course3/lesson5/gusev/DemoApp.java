package course3.lesson5.gusev;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class DemoApp {
    // чтение без синхронайза, оптимален когда чтений больше чем записей,
    // для каждой новой записи создается новый массив с новым элементом а те кто читал старую ее дочитывают
    List<Integer> list = new CopyOnWriteArrayList<>();

    // все методы листа обернутся в синхронайзд
    List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());

    // делает блокировку на уровне бакета
    Map<String, String > map = new ConcurrentHashMap<>();


}
