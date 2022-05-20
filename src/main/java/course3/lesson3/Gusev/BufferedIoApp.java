package course3.lesson3.Gusev;

import java.io.*;

public class BufferedIoApp {
    public static void main(String[] args) {

        try(FileOutputStream fous = new FileOutputStream("demo.txt");
            BufferedOutputStream out = new BufferedOutputStream(fous, 10000)){

            long start = System.currentTimeMillis();
            for (int i = 0; i < 10_000; i++) {
                out.write(65);
            }
            System.out.println("t1 = " + (System.currentTimeMillis() - start));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("demo.txt"))){


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
