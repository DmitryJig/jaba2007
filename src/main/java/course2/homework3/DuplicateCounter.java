package course2.homework3;

import java.util.Map;
import java.util.TreeMap;

/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
 * вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово
 */
public class DuplicateCounter {

    public static void main(String[] args) {
        // Лень было делать массив, сделал метод для его получения из предложения))
        String[] arrayWords = getArray("Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово");
        // Получаем мапу где ключи это слова а значения - количество вхождений
        Map<String, Integer> map = getMapWordCount(arrayWords);
        // Печатаем список уникальных слов
        System.out.println(map.keySet());
        // Печатаем слова и количество их вхождений
        map.forEach((x, y) -> System.out.println(x + " \t встретилось " + y + " раз"));
    }

    public static Map<String, Integer> getMapWordCount(String[] arrayWords) {
        Map<String, Integer> map = new TreeMap<>();

        for (String element : arrayWords) {
            if (map.containsKey(element)) {
                int count = map.get(element);
                count++;
                map.put(element, count);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    /**
     * Метод делает массив из строки
     * @param str строка из слов
     * @return строковый массив
     */
    public static String[] getArray(String str) {

        return str.replaceAll("\\p{P}", "").split(" "); // Удаляем из строки мусор и разбиваем по пробелям
    }
}



