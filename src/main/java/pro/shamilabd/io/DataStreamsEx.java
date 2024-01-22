package pro.shamilabd.io;

import java.io.*;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 25.05.2023
 */
public class DataStreamsEx {
    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("io_files\\DataStreamsEx.bin"));
             DataInputStream input = new DataInputStream(new FileInputStream("io_files\\DataStreamsEx.bin"))) {
            output.writeBoolean(true);
            output.writeByte(122);
            output.writeInt(2000000);
            output.writeFloat(3.14F);
            output.writeLong(123321321321L);
            output.writeChar('S');
            System.out.println("Write done");
            System.out.println(input.readBoolean());
            System.out.println(input.readByte());
            System.out.println(input.readInt());
            System.out.println(input.readFloat());
            System.out.println(input.readLong());
            System.out.println((char) input.readByte());
            System.out.println("Read done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
