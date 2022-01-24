package course1.lesson7;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Жора", 95);
        Cat cat3 = new Cat("Дрищ", 2);
        Plate plate = new Plate(100);
        plate.info();

        Cat[] cats = {cat1, cat2, cat3};

        feedCats(cats, plate);

        plate.info();
        plate.appendFood(5); // добавляем еду на тарелку
        plate.info();
        cat3.eat(plate);
        plate.info();
    }

    //Кормим всех котов
    public static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat: cats) {
            cat.eat(plate);
            // выводим уровень сытости
            System.out.println("У кота " + cat.getName() + " уровень сытости = " + cat.isSatiety());
        }
    }
}
