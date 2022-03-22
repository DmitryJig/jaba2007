package course2.homework1.Task4;

/**
 * Класс беговая дорожка
 */
public class Racetrack implements Let {

    private int distance;

    public Racetrack(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcome(Entity entity) {
        if (entity.isActive()) {
            entity.run(distance);
        }
    }
}
