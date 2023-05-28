package com.shamilabd.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 28.05.2023
 */
public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("io_files\\FileEx\\someFile.txt");
        File folder = new File("C:\\Java\\Projects\\Java_advanced\\io_files\\FileEx\\javaSource");

        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath(): " + folder.getAbsolutePath());
        line();

        System.out.println("file.isAbsolute(): " + file.isAbsolute());
        System.out.println("folder.isAbsolute(): " + folder.isAbsolute());
        line();

        System.out.println("file.isDirectory(): " + file.isDirectory());
        System.out.println("folder.isDirectory(): " + folder.isDirectory());
        line();

        System.out.println("file.isFile(): " + file.isFile());
        System.out.println("folder.isFile(): " + folder.isFile());
        line();

        System.out.println("file.exists(): " + file.exists());
        System.out.println("folder.exists(): " + folder.exists());
        line();

        File notExistsFile = new File("io_files\\FileEx\\notExistsFile.txt");
        File notExistsFolder = new File("C:\\Java\\Projects\\Java_advanced\\io_files\\FileEx\\notExistsFolder");
        System.out.println("notExistsFile.exists(): " + notExistsFile.exists());
        System.out.println("notExistsFolder.exists(): " + notExistsFolder.exists());
        line();

        System.out.println("notExistsFile.createNewFile(): " + notExistsFile.createNewFile());
        System.out.println("notExistsFolder.mkdir(): " + notExistsFolder.mkdir());
        line();

        System.out.println("file.length(): " + file.length());
        System.out.println("folder.length(): " + folder.length());
        line();

        System.out.println("notExistsFile.delete(): " + notExistsFile.delete());
        System.out.println("notExistsFolder.delete(): " + notExistsFolder.delete());
        System.out.println("folder.delete(): " + folder.delete()); // can't, folder is not empty
        line();

        File fileExFolder = new File("C:\\Java\\Projects\\Java_advanced\\io_files\\FileEx");
        File[] files = fileExFolder.listFiles();
        System.out.println(Arrays.toString(files));
        line();

        System.out.println("file.isHidden(): " + file.isHidden());
        System.out.println("folder.isHidden(): " + folder.isHidden());
        line();

        System.out.println("file.canRead(): " + file.canRead());
        System.out.println("folder.canRead(): " + folder.canRead());
        line();

        System.out.println("file.canWrite(): " + file.canWrite());
        System.out.println("folder.canWrite(): " + folder.canWrite());
        line();

        System.out.println("file.canExecute(): " + file.canExecute());
        System.out.println("folder.canExecute(): " + folder.canExecute());
        line();
    }
}
