package pro.shamilabd.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 31.05.2023
 */
public class FullCopyDirectoryEx {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("nio_files\\PathEx");
        Path destination = Paths.get("nio_files\\FullCopyDirectoryEx");
        FullCopyDirectoryVisitor fullCopyDirectoryVisitor = new FullCopyDirectoryVisitor(source, destination);
        fullCopyDirectoryVisitor.copyContainsDirectory();
    }
}

class FullCopyDirectoryVisitor extends SimpleFileVisitor<Path> {
    Path source;
    Path sourceParent;
    Path destination;
    boolean isNotSkiptedRootFolderYet = true;

    public FullCopyDirectoryVisitor(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
        sourceParent = source.getParent();
    }

    public void copyContainsDirectory() throws IOException {
        Files.walkFileTree(source, this);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newPath = destination.resolve(sourceParent.relativize(dir));
        System.out.println("Копируем папку " + dir + " в: " + newPath);
        Files.copy(dir, newPath); // , StandardCopyOption.REPLACE_EXISTING
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newPath = destination.resolve(sourceParent.relativize(file));
        System.out.println("Копируем файл " + file.getFileName() + " в " + newPath);
        Files.copy(file, newPath); // , StandardCopyOption.REPLACE_EXISTING
        return FileVisitResult.CONTINUE;
    }
}