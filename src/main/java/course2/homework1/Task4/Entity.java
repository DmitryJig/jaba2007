package course2.homework1.Task4;

/**
 * Интерфейс существ, содержить методы бежать, прыгать и метод возвращающий значение о выбывании игрока с дистанции
 */
public interface Entity {

    boolean isActive();
    void run(int distance);
    void jump(int height);
}
