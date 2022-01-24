package course1.lesson7;

/**
 * Класс тарелка, объект которого будет передаваться в класс кот
 */
public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n){
            food -= n;
            return true;
        }
        return false;
    }

    // метод для добавления еды на тарелку
    public void appendFood(int foodAdditive) {
        System.out.println("на тарелку добавлено " + foodAdditive + " кг еды");
        food += foodAdditive;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
