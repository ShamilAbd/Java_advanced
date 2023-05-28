package com.shamilabd.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 28.05.2023
 */
public class BufferChannelEx {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {
        try (RandomAccessFile file = new RandomAccessFile("nio_files\\BufferChannelEx.txt", "rw");
             FileChannel channel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            StringBuilder stix = new StringBuilder();

            int byteRead = channel.read(buffer);
            while (byteRead > 0) {
                System.out.println("Read bytes: " + byteRead);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    stix.append((char) buffer.get());
                }

                buffer.clear();
                byteRead = channel.read(buffer);
            }

            System.out.println(stix);

            writeMessage(channel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMessage(FileChannel channel) {
        String quote = "\n\nSuccess is the child of audacity.\nBenjamin Disraeli";
//        ByteBuffer buffer = ByteBuffer.allocate(quote.getBytes(StandardCharsets.UTF_8).length);
//        buffer.put(quote.getBytes(StandardCharsets.UTF_8));
//        buffer.flip();
        ByteBuffer buffer = ByteBuffer.wrap(quote.getBytes(StandardCharsets.UTF_8)); // делает все 3 действия сразу
        try {
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
