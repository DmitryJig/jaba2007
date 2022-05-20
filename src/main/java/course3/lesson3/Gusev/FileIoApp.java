package course3.lesson3.Gusev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileIoApp {
    public static void main(String[] args) {
        
        try(FileOutputStream out = new FileOutputStream("demo.txt")){
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10_000; i++) {
                out.write(65);
            }
            System.out.println("t1 = " + (System.currentTimeMillis() - start));

            byte[] arr = new byte[10_000];
            Arrays.fill(arr, (byte) 65);
            start = System.currentTimeMillis();
            out.write(arr);
            System.out.println("t2 = " + (System.currentTimeMillis() - start));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try(FileInputStream inputStream = new FileInputStream("demo.txt")){
//            while (inputStream.available() > 0) {
//                System.out.print((char) inputStream.read());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
