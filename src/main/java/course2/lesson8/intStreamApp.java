package course2.lesson8;

import java.util.stream.IntStream;

public class intStreamApp {

    public static void main(String[] args) {
        int num = IntStream.iterate(0, i -> i + 3)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .findFirst().getAsInt();
        System.out.println(num);


    }

}
