package course3.lesson1.homework1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    // Если коробка пустая ложим в нее что хотим, если есть хоть один фрукт то положить можно только такой же
    public boolean addFruit(T fruit){
        if (isFruitValid(fruit)){
            return fruits.add(fruit);
        }
        return false;
    }

    public <T> boolean isFruitValid(T fruit) {
        return fruits.isEmpty() || fruits.contains(fruit);
    }

    public boolean deleteFruit(T fruit){
        if (fruits.contains(fruit)){
            return fruits.remove(fruit);
        } else System.out.println("Этого фрукта нет в корзине");
        return false;
    }

    /**
     * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта
     * и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны)
     * @return вес коробки с фруктами
     */
    public float getWeight(){
        float weight = 0.0f;
        for (T fruit: fruits){
            weight +=fruit.getWEIGHT();
        }
        return weight;
    }

    /**
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
     * коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
     * равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
     * апельсинами;
     * @param box - Коробка с которой сравниваем массу
     * @return true – если их массы равны, false в противоположном случае
     */
    public boolean compare (Box box){
        return !(Math.abs(this.getWeight() - box.getWeight()) > 0.0001);
    }

    /**
     *f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
     * объекты, которые были в первой;
     */
    public boolean transferFruitsInBox(Box<T> toBox) {
        for (int i = fruits.size() - 1; i >= 0; i--) {
            if (!(toBox.addFruit(this.fruits.get(i)) && this.deleteFruit(this.fruits.get(i)))) {
                System.out.println("Ошибка при пересыпании из одной коробки в другую");
                return false;
            }
        }
        System.out.println("Фрукты пересыпаны успешно");
        return true;
    }
}
