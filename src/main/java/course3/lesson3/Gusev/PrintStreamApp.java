package course3.lesson3.Gusev;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamApp {
    public static void main(String[] args) {
        try (final FileOutputStream outputStream = new FileOutputStream("demo.txt", true);
             PrintStream printStream = new PrintStream(outputStream)) {

            printStream.println("Hello java!!!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
