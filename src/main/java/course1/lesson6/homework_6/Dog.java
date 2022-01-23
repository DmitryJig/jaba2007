package course1.lesson6.homework_6;

public class Dog extends Animal {
    static final int MAX_RUN_DOG = 500;
    static final int MAX_SWIM_DOG = 10;

    Dog(String name) {
        super(MAX_RUN_DOG, MAX_SWIM_DOG, name);
    }

    @Override
    public void run(int distance) {
        if (distance <= DIST_RUN) {
            System.out.println("Пес " + name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Пес " + name +" не добежал, слишком большая дистанция");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= DIST_RUN) {
            System.out.println("Пес " + name + " проплыл " + distance + " м.");
        } else {
            System.out.println("Пес " + name +" утонул, слишком большая дистанция");
        }
    }
}
