package course1.lesson6.homework_6;

/**
 * Суперкласс наследниками которого будут классы Dog и Cat
 */
public abstract class Animal {
    protected final int DIST_RUN;
    protected final int DIST_SWIM;
    String name;

    public Animal(int dist_run, int dist_swim, String name) {
        DIST_RUN = dist_run;
        DIST_SWIM = dist_swim;
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
