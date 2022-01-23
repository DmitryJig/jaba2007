package course1.lesson6.homework_6;

/**
 * Суперкласс наследниками которого будут классы Dog и Cat
 */
public class Animal {
    protected final int DIST_RUN;
    protected final int DIST_SWIM;
    String name;

    public Animal(int dist_run, int dist_swim, String name) {
        DIST_RUN = dist_run;
        DIST_SWIM = dist_swim;
        this.name = name;
    }

    public void run(int distance) {

        if (distance <= DIST_RUN) {
            System.out.println("Животное " + name + " пробежало " + distance + " м.");
        } else {
            System.out.println("Животное " + name + " не добежало, батарейка села");
        }
    }

    public void swim(int distance) {

        if (distance <= DIST_SWIM) {
            System.out.println("Животное " + name + " проплыло " + distance + " м.");
        } else {
            System.out.println("Животное " + name + " утонуло");
        }
    }
}
