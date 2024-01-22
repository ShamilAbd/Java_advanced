package pro.shamilabd.io;

import java.io.*;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 25.05.2023
 *  Только для работы с текстовыми файлами
 */
public class BufferedWriterAndReaderEx {
    public static void main(String[] args) {
        simpleBufferedWriter();
        simpleBufferedReader();
    }

    public static void simpleBufferedWriter() {
        String text = "Message from simpleBufferedWriter\n"
                + "Now: " + System.currentTimeMillis();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io_files\\BufferedWriterAndReaderEx.txt"))) { // без true
            bufferedWriter.write(text);
            System.out.println("Write done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simpleBufferedReader() {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("io_files\\BufferedWriterAndReaderEx.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            System.out.println("Read done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuffer.toString());
    }
}
