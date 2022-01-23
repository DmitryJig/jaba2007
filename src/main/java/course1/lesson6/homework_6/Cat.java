package course1.lesson6.homework_6;

public class Cat extends Animal {

    static final int MAX_RUN_CAT = 200;
    static final int MAX_SWIM_CAT = 0;

    Cat(String name) {
        super(MAX_RUN_CAT, MAX_SWIM_CAT, name);
    }

    @Override
    public void run(int distance) {
        if (distance <= DIST_RUN) {
            System.out.println("Кот " + name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Кот " + name +" не добежал, слишком большая дистанция");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + name + " утонул, он не умеет плавать");
    }
}
