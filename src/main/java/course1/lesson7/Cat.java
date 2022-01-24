package course1.lesson7;

/**
 * А это класс кот, объект которого будет есть и уменьшать количество еды в классе тарелка
 */
public class Cat {
    private  String name;
    private int appetite;
    private boolean satiety; // поле сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat (Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
            System.out.println("Кот " + name + " покушал " + appetite + " кг еды" + " сытость = " + satiety);
        } else {
            System.out.println("Коту " + name + " не хватило еды" + " сытость = " + satiety);
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}

