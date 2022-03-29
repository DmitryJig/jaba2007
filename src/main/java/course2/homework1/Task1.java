package course2.homework1;

/**
 * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
 * классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
 * консоль).
 */

public class Task1 {
    public static void main(String[] args) {
        Human human1 = new Human();
        Cat cat1 = new Cat();
        Robot robot1 = new Robot();
        human1.jump();
        human1.run();
        cat1.jump();
        cat1.run();
        robot1.jump();
        robot1.run();
    }
}

interface Entity{
    void run();
    void jump();
}



class Human implements Entity{

    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }
}

class Cat implements Entity {

    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгнул");
    }
}

class Robot implements Entity {

    @Override
    public void run() {
        System.out.println("Робот пробежал");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгнул");
    }
}
