package course1.lesson6.homework_6;


import java.util.ArrayList;
import java.util.List;

public class AnimalsApp {
    public static void main(String[] args) {

        Animal dogBobik = new Dog("бобик");
        Animal cat1 = new Cat("Васька");
        Animal cat2 = new Cat("Егор");
        cat2.run(10);
        dogBobik.run(1000);
        cat1.swim(1);
        Animal[] animals = {dogBobik, cat1, cat2};
        AnimalsCounter(animals);
    }

    // метод для подсчета животных, котов и собак, можно было вернуть Map но пока думаю рановато
    public static void AnimalsCounter(Animal[] animals) {
        int animalCount = 0;
        int catCount = 0;
        int dogCount = 0;
        for (Animal animal : animals) {
            animalCount++;
            if (animal instanceof Cat) {
                catCount++;
            } else if (animal instanceof Dog) {
                dogCount++;
            }
        }
        System.out.println("В массиве " + animalCount + " животных, из них " + catCount + " котов и "
                + dogCount + " собак");
    }
}
