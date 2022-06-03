package course3.lesson6.efremov.testing;

public class Calculator {
    // TDD test driven development
    public int add(int a, int b){
        long res = (long) a + b;
        if(res != (a + b)){
            throw new RuntimeException("слишком ьольшое число");
        }
        return a + b;
    }
}
