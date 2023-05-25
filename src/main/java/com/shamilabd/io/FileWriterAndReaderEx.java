package com.shamilabd.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 25.05.2023
 *  Только для работы с текстовыми файлами
 */
public class FileWriterAndReaderEx {
    public static void main(String[] args) throws IOException {
        simpleWriter();
        simpleReader();
        readerWithAutoclose();
    }

    public static void simpleWriter() throws IOException {
        String text = "It's message from FileWriter.\n"
                + "And it's second line test.\n"
                + "Now: " + System.currentTimeMillis();
        FileWriter writer = null;
        try {
            writer = new FileWriter("io_files\\FileWriterAndReaderEx.txt"); // добавить true если надо добавлять текст в конец файла, а не перезаписывать все.
//            for (int i = 0; i < text.length(); i++) { // посимвольная запись
//                writer.write(text.charAt(i));
//            }
            writer.write(text); // тоже посимвольная, но так удобнее
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void simpleReader() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        FileReader reader = null;
        try {
            reader = new FileReader("io_files\\FileWriterAndReaderEx.txt");
            int symbol;
            while ((symbol = reader.read()) >= 0) {
                stringBuffer.append((char) symbol);
            }
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    public static void readerWithAutoclose() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader reader = new FileReader("io_files\\FileWriterAndReaderEx.txt")) { // using Closeable interface -> AutoCloseable
            int symbol;
            while ((symbol = reader.read()) >= 0) {
                stringBuffer.append((char) symbol);
            }
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
























