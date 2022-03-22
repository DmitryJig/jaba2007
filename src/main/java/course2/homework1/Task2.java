package course2.homework1;

/**
 * 2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
 * должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
 * печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 */
public class Task2 {


    public static void main(String[] args) {
        Entity cat = new Cat();     //Берем объекты из 1 задачи
        Entity human = new Human();
        Entity robot = new Robot();

        Let racetrack = new Racetrack();  // Создали объект беговой дорожки
        Let wall = new Wall(); // создали объект стена

        // передали препятствиям кота, человека и робота
        racetrack.overcome(cat);
        racetrack.overcome(human);
        racetrack.overcome(robot);

        wall.overcome(cat);
        wall.overcome(human);
        wall.overcome(robot);
    }
}

// Интерфейс препятствие с методом "преодоление"
interface Let {
    public void overcome(Entity entity);
}

class Racetrack implements Let {

    @Override
    public void overcome(Entity entity) {
        System.out.println("Преодоление беговой дорожки");
        entity.run();
    }
}

class Wall implements Let {

    @Override
    public void overcome(Entity entity) {
        System.out.println("Преодоление стены");
        entity.jump();
    }
}