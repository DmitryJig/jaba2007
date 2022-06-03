package course3.lesson6.gusev;

public class AssertApp {
    // в джава assert это ключевое слово
    // так делали первобытные программисты
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        assert a < b; // если ассерт не выполняется приложение падает с ассершн еррором

        System.out.println("ok");
    }
}
