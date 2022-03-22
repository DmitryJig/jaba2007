package course2.homework1;

import java.util.Arrays;
import java.util.List;

/**
 * 3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
 * этот набор препятствий.
 */

public class Task3 {
    public static void main(String[] args) {
        //Создаем массив участников
        Entity[] entityes = new Entity[]{new Cat(), new Human(), new Robot()};
        Let[] lets = new Let[]{new Racetrack(), new Wall()};

        for (int i = 0; i < lets.length; i++) {
            for (int j = 0; j < entityes.length; j++) {
                lets[i].overcome(entityes[j]);
            }
        }
    }
}
