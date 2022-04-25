package course3.lesson1.homework1;

public class BoxApp {

    public static void main(String[] args) {
        BoxApp boxApp = new BoxApp();
        Box<Orange> orangeBox1 = boxApp.createBoxWithSomeOranges(5);
        Box<Orange> orangeBox2 = boxApp.createBoxWithSomeOranges(4);
        Box<Apple> appleBox = boxApp.createBoxWithSomeApples(9);
        System.out.println(orangeBox1.addFruit(new Orange()));
        System.out.println(orangeBox1.getWeight());
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox.compare(orangeBox1));
        System.out.println(appleBox.compare(orangeBox2));
        orangeBox1.transferFruitsInBox(orangeBox2);
        System.out.println(orangeBox2.getWeight());

    }

    public Box<Orange> createBoxWithSomeOranges(int count) {
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < count; i++) {
            orangeBox.addFruit(new Orange());
        }
        return orangeBox;
    }

    public Box<Apple> createBoxWithSomeApples(int count) {
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < count; i++) {
            appleBox.addFruit(new Apple());
        }
        return appleBox;
    }
}
