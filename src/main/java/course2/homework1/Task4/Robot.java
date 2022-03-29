package course2.homework1.Task4;

public class Robot implements Entity {

    private static final int MAX_DISTANCE_RUN = 100;
    private static final int MAX_HEIGHT_JUMP = 0;
    private boolean isActive = true;

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_DISTANCE_RUN){
            isActive = false;
            System.out.println("Робот не смог пробежать дистанцию и покидает соревнование");
        } else {
            System.out.println("Робот пробежал дистанцию и может продолжать соревнование");
        }
    }

    @Override
    public void jump(int height) {
        if (height > MAX_HEIGHT_JUMP) {
            isActive = false;
            System.out.println("Робот не смог перепрыгнуть стену и покидает соревнование");
        } else {
            System.out.println("Робот перепрыгнул стену и может продолжать соревнование");
        }
    }
}
