package pro.shamilabd.basics.exceptions;

import pro.shamilabd.elementary.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static pro.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 21.04.2023
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        oldReadMethod();
        Utils.line(true);
        oldWriteMethod();
        oldReadMethod();
    }

    public static void oldReadMethod() throws IOException {
        File text = new File("test1.txt");
//        File text = new File("test1888.txt"); // File not exists, for test FileNotFoundException
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(text);
            int symbol;
            while ((symbol = fis.read()) != -1){ // end of file = -1
                System.out.print((char) symbol);
            }
//        } catch (IOException e) { // can't write here, because it will be unreachable statement, compile time exception
//            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("I caught FileNotFoundException! :-) My first caught exception. I will put him in jar");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            /*
            Блок finally может не выполниться при:
            1) был вызов System.exit(0);
            2) Сбой JVM, например ошибка сегментации
            3) Бесконечный цикл
             */
            // Обязательно освобождаем ресурсы
            fis.close(); // close() can throw IOException
            System.out.println("This block will be executed always");
        }
    }

    public static void oldWriteMethod() throws IOException {
        File text = new File("test1.txt");
        FileOutputStream fos = null;
        try{
//            fos = new FileOutputStream(text);// Override all information!!!
            fos = new FileOutputStream(text, true); // add new text
            fos.write("New text in file.\r\n".getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fos.close(); // close() can throw IOException
        }
    }
}
