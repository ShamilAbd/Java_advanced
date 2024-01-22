package pro.shamilabd.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 25.05.2023
 */
public class FISAndFOSEx {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("io_files\\FISAndFOSEx.jpg");
             FileOutputStream oututStream = new FileOutputStream("io_files\\FISAndFOSEx_new.jpg")) {
            int imageByte;
            while ((imageByte = inputStream.read()) >= 0) {
                oututStream.write(imageByte);
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
