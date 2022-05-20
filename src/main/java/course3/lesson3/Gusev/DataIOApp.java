package course3.lesson3.Gusev;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOApp {
    public static void main(String[] args) {

        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("demo.txt", true))){
            outputStream.writeUTF("we love java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
