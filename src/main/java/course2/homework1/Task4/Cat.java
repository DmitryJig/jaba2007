package course2.homework1.Task4;

/**
 * Модель кошки
 */
public class Cat implements Entity {

    private static final int MAX_DISTANCE_RUN = 200;
    private static final int MAX_HEIGHT_JUMP = 3;
    private boolean isActive = true;

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_DISTANCE_RUN){
            isActive = false;
            System.out.println("Кот не смог пробежать дистанцию и покидает соревнование");
        } else {
            System.out.println("Кот пробежал дистанцию и может продолжать соревнование");
        }
    }

    @Override
    public void jump(int height) {
        if (height > MAX_HEIGHT_JUMP) {
            isActive = false;
            System.out.println("Кот не смог перепрыгнуть стену и покидает соревнование");
        } else {
            System.out.println("Кот перепрыгнул стену и может продолжать соревнование");
        }
    }
}
