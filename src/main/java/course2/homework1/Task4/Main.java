package course2.homework1.Task4;

/**
 * 4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
 * на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
 * препятствий не идет.
 */
public class Main {

    public static void main(String[] args) {
//создали массив существ
        Entity[] entities = new Entity[]{new Cat(), new Robot(), new Human()};
// создали массив препятствий
        Let[] lets = new Let[]{new Racetrack(100), new Wall(1)};

        for (int i = 0; i < entities.length; i++) {
            for (int j = 0; j < lets.length; j++) {
                lets[j].overcome(entities[i]);
            }
        }
    }
}
