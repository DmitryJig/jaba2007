package course2.lesson8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsApp {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100)); //0-99
        }
        System.out.println(list);

        long count = list.stream()
                .limit(50)
                .peek(i -> System.out.print(i + " ")) // показывает что есть в стриме прямо сейчас
                .filter(integer -> integer % 2 == 0)
                .count();
        System.out.println();
        System.out.println(count);

        list = list.stream()
                .limit(50)
                .map(i -> i * 1000)
                .collect(Collectors.toList());
        System.out.println(list);

        String s = list.stream()
                .limit(50)
                .sorted()
                .distinct()  //оставляеттолько уникальные элементы, тяжелые операции для памяти
                .map(integer -> String.valueOf(integer))
                .collect(Collectors.joining("<->"));
        System.out.println(s);

        Stream<String> stringStream = Stream.of("aaa", "bbbb", "cccc", "aaaa", "bbb", "aaaa");
        Set<String> collect = stringStream.filter(str -> str.length() == 4)
                .map(str -> str.toUpperCase())
                .collect(Collectors.toSet());
        System.out.println(collect);

        Stream<String> stringStream2 = Stream.of("aaa", "bbbb", "cccc", "aaaa", "bbb", "aaaa");
        boolean isAll4 = stringStream2
                .filter(x -> x.length() == 4)
                .map(str -> str.toUpperCase())
                .allMatch(y -> y.length() == 4);
        System.out.println(isAll4);

        Stream<String> stringStream3 = Stream.of("aaa", "bbbb", "cccc", "aaaa", "bbb", "aaaa");

        Map<String, Integer> map = stringStream3
                .collect(Collectors.toMap(str -> str, str -> 1, (v1, v2) -> v1 + 1));
// в мапу ложим ключом самого себя, значением положить 1, если такое значение есть, взять значение v1 прибавить к нему 1
        System.out.println(map);

    }
}
