package pro.shamilabd.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 04.06.2023
 */
public class ScannerEx {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        simpleExample();
//        readLine();
//        readWord();
        advancedScannerEx();
    }

    public static void advancedScannerEx() {
        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try {
            scanner = new Scanner(new FileReader(new File("io_files\\FileWriterAndReaderEx.txt")));
            scanner.useDelimiter("\\W");
            while (scanner.hasNext()) {
                String word = scanner.next();
                set.add(word);
            }
            for (String word : set) {
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readWord() {
        System.out.println("Введите пару слов:");
        while (scanner.hasNext()) {
            String line = scanner.next();

            if (line.equals("exit")) {
                break;
            }

            // эхо-тест
            System.out.println(line);
        }
        scanner.close();
    }

    public static void readLine() {
        System.out.println("Введите пару слов:");
        String line = scanner.nextLine();
        System.out.println("Вы написали: " + line);
        System.out.println("Введите 2 строки:");
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        System.out.println("Вы написали: " + line1);
        System.out.println(line2);
        scanner.close();
    }

    public static void simpleExample() {
        System.out.println("Введите 1 число:");
        int num1 = scanner.nextInt(); // InputMismatchException - для нечисел
        System.out.println("Введите 2 число:");
        int num2 = scanner.nextInt();

        System.out.println("*: " + (num1 * num2));
        System.out.println("/: " + (num1 / num2));
        System.out.println("+: " + (num1 + num2));
        System.out.println("-: " + (num1 - num2));
        scanner.close();
    }
}

