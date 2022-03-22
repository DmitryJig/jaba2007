package course2.homework1.Task4;

/**
 * Класс стена
 */
public class Wall implements Let {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Entity entity) {
        if (entity.isActive()) {
            entity.jump(height);
        }
    }
}
