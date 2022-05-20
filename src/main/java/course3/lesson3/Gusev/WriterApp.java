package course3.lesson3.Gusev;

import java.io.*;

public class WriterApp {
    public static void main(String[] args) {
        try(Writer writer = new BufferedWriter(new FileWriter("demo.txt"))){
            writer.write("fffffhhhhh");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(Reader reader = new BufferedReader(new FileReader("demo.txt"))){
            reader.skip(4);

            while (reader.ready()){
                System.out.println((char) reader.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
