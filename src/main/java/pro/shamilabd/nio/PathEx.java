package pro.shamilabd.nio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 28.05.2023
 */
public class PathEx {
    public static void main(String[] args) throws IOException {
        pathExample();
        fileCopyMoveEx();
        writeAndReadEx();
    }

    public static void pathExample() throws IOException {
        Path file = Paths.get("PathExFile.txt");
        Path directory = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx");

        System.out.println("file.getFileName: " + file.getFileName());
        System.out.println("directory.getFileName: " + directory.getFileName());
        line();

        System.out.println("file.getParent: " + file.getParent());
        System.out.println("directory.getParent: " + directory.getParent());
        line();

        System.out.println("file.getRoot: " + file.getRoot());
        System.out.println("directory.getRoot: " + directory.getRoot());
        line();

        System.out.println("file.isAbsolute: " + file.isAbsolute());
        System.out.println("directory.isAbsolute: " + directory.isAbsolute());
        line();

        System.out.println("file.toAbsolutePath: " + file.toAbsolutePath());
        System.out.println("directory.toAbsolutePath: " + directory.toAbsolutePath());
        line();

        System.out.println("directory.resolve: " + directory.resolve(file));
        line();

        Path otherDirectory = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx\\SomeDir1\\SomeDir2\\PathExFile.txt");
        System.out.println("directory.relativize: " + directory.relativize(otherDirectory));
        line();

        Path otherDirectory2 = Paths.get("C:\\Games\\nio_files\\PathEx\\SomeDir1\\SomeDir2\\PathExFile.txt");
        System.out.println("directory.relativize: " + directory.relativize(otherDirectory2));
        line();

        Path file2 = Paths.get("nio_files\\PathExFile.txt");
        if (!Files.exists(file2)) {
            Files.createFile(file2);
        }

        if (!Files.exists(directory)) {
            Files.createDirectory(directory);
        }
        System.out.println("Files.isReadable: " + Files.isReadable(file2));
        System.out.println("Files.isExecutable: " + Files.isExecutable(file2));
        System.out.println("Files.isHidden: " + Files.isHidden(file2));
        line();

        Path file3 = Paths.get("nio_files\\BufferChannelEx.txt");
        Path directory2 = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx");
        System.out.println("Files.isSameFile(file2, file3): " + Files.isSameFile(file2, file3));
        line();

        System.out.println("Files.size(file3): " + Files.size(file3));
        System.out.println("Files.size(directory): " + Files.size(directory));
        line();

        System.out.println("Files.getAttribute(file3 - creationTime): " + Files.getAttribute(file3, "creationTime"));
        System.out.println("Files.getAttribute(file3 - size): " + Files.getAttribute(file3, "size"));
        line();

        Map<String, Object> attrs = Files.readAttributes(file3, "*");
        for (Map.Entry<String, Object> entry : attrs.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        line();
    }

    public static void fileCopyMoveEx() throws IOException {
        Path file = Paths.get("nio_files\\PathExFile.txt");
        Path directory = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx");
        Path directoryA = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx\\A");
        Path directoryB = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx\\B");
        Path directoryD = Paths.get("C:\\Java\\Projects\\Java_advanced\\nio_files\\PathEx\\D");

        Files.copy(file, directory.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Done");
        line();

//        Files.copy(directoryB, directoryA.resolve("B"), StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("Done");
//        line();

//        Files.move(directoryD, directoryA.resolve("D"), StandardCopyOption.REPLACE_EXISTING);
//        System.out.println("Done");
//        line();

//        Files.move(Paths.get("nio_files\\PathEx\\PathExFile2.txt"), Paths.get("nio_files\\PathEx\\NewPathExFile2.txt"), StandardCopyOption.REPLACE_EXISTING); // Переименовать
//        System.out.println("Done");
//        line();

//        Files.delete(Paths.get("nio_files\\PathEx\\NewPathExFile2.txt"));
//        System.out.println("Done");
//        line();
    }

    public static void writeAndReadEx() throws IOException {
        Path file = Paths.get("nio_files\\PathExFile.txt");
        String message = "Hello world. Level 2.\nSecond line test.";
        Files.write(file, message.getBytes(StandardCharsets.UTF_8));

        List<String> lines = Files.readAllLines(file);
        for (String line :lines) {
            System.out.println(line);
        }
    }
}
