package com.shamilabd.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 30.05.2023
 */
public class WalkFileTreeEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("io_files");
        Files.walkFileTree(path, new TestFileVisitor());
    }
}

class TestFileVisitor implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Вошли в папку: " + dir);
//        return FileVisitResult.CONTINUE;
//        return FileVisitResult.TERMINATE;
//        return FileVisitResult.SKIP_SUBTREE;
//        return FileVisitResult.SKIP_SIBLINGS;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Смотрим файл: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Ошибка при чтении файла: " + file.getFileName() + ", " + exc.getMessage());
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Вышли из папки: " + dir);
        return FileVisitResult.CONTINUE;
    }
}
