package pro.shamilabd.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 26.05.2023
 */
public class RandomAccessFileEx {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("io_files\\RandomAccessFileEx.txt", "rw")) {
            int element = randomAccessFile.read(); // прочел и сдвинул указатель на следующий байт
            System.out.println((char) element);

            element = randomAccessFile.read();
            System.out.println((char) element);

            String line = randomAccessFile.readLine();
            System.out.println(line);

            randomAccessFile.seek(50);

            line = randomAccessFile.readLine();
            System.out.println(line);

            randomAccessFile.seek(0);
            randomAccessFile.writeBytes("Write over poem text"); // :-(
            randomAccessFile.seek(0);
            line = randomAccessFile.readLine();
            System.out.println(line);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
