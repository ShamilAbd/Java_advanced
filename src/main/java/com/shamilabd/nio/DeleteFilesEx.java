package com.shamilabd.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 31.05.2023
 */
public class DeleteFilesEx {
    public static void main(String[] args) throws IOException {
        Path deleteThisPath = Paths.get("nio_files\\FullCopyDirectoryEx\\PathEx");
        DeleteFilesVisitor deleteFilesVisitor = new DeleteFilesVisitor(deleteThisPath);
        Files.walkFileTree(deleteThisPath, deleteFilesVisitor);
    }
}

class DeleteFilesVisitor extends SimpleFileVisitor<Path> {
    Path pathForDelete;

    public DeleteFilesVisitor(Path path) {
        pathForDelete = path;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file);
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir);
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}
