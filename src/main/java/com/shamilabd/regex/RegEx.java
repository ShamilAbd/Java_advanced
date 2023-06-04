package com.shamilabd.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 31.05.2023
 */
public class RegEx {
    private static int messageNum = 1;

    public static void main(String[] args) {
//        patternAndMatcher();
//        matchesAndSplit();
//        replaceAll();
//        groupEx();
        printFAndFormatEx();
    }

    public static void patternAndMatcher() {
        regExTester("ABCD ABCE ABCFABCGABCH abcd abce", "ABC"); // ABC - просто совпадение с текстом
        regExTester("ABCD ABCE ABCFABCGABCH abcd abce", "[ABC]"); // [AFJ] - любой 1 из символов в скобках
        regExTester("ABDOP_ABFOP_ADCOP", "AB[C-F]OP"); // [C-F] - в диапазоне от C до F
        regExTester("abcd abce abc5abcg6abch", "abc[e-g4-7]"); // сложный диапазон
        regExTester("abcd abce abc5abcg6abch", "abc[^e-g4-7]"); // [^... - кроме тех, что в скобках

        regExTester("abcd abce abc5abcg6abch", "abc[e|5]"); // | - или
        regExTester("abcd abce abc5abcg6abch", "abc."); // . - любой символ
        regExTester("abcd abce abc5abcg6abch", "^abc"); // ^ - начало строки
        regExTester("abcd abce abc5abcg6abch", "bch$"); // $ - конец строки
        regExTester("abcd abce abc5abcg6abch", "\\d"); // 1 цифра от 0 до 9
        regExTester("abcd abce abc5abcg6abch", "\\D"); // НЕ 1 цифра от 0 до 9

        regExTester("abc \\ abch", " \\\\ "); // найти \
        regExTester("abcd abce abc5abcg6abch", "\\w"); // [a-zA-Z0-9_]
        regExTester("abcd =abce + abc5a;%:bcg6abch", "\\W"); // [^a-zA-Z0-9_]
        regExTester("abcd abce abc5abcg6abch", "\\w+"); // + - 1 или более повторений
        regExTester("abcd abce abc5abcg6ab", "\\w{4}"); // {4} - четыре повторений

        regExTester("abcd abce abc5abcg6ab", "\\w{3,6}"); //
        regExTester("abcd abce abc5abcg6abch", "\\w{5,}"); //
        regExTester("abcd ab\tce abc5a   bcg6\nabch", "\\s+"); // [\t\n\r\f]
        regExTester("abcd abab abc5abab6abch", "(ab){2,3}"); //
        regExTester("abcd abab abc5abab6abch", "b(ab)?"); //

        regExTester("abcd abab abc5abab6abch", "(ab)*"); //
        regExTester("abcd abab abc5abab6abch", "\\Aabc"); //
        regExTester("abcd abab abc5abab6abch", "bch\\Z"); //
        regExTester("abcd abab abc5abab6abch", "\\babab\\b"); //
        regExTester("abcd abab abc5abab6abch", "\\Babab\\B"); //
    }

    public static void regExTester(String rawText, String patternText) {
        line();
        System.out.println(messageNum++ + ") \"" + rawText + "\" : \"" + patternText + "\"");
        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(rawText);

        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + " - \"" + matcher.group() + "\"");
        }
        line();
    }

    public static void matchesAndSplit() {
        String mail = "shamil@abdullin.ru";
        boolean isMailAdress = mail.matches("\\w+@\\w+.(ru|com)");
        System.out.println(isMailAdress);

        mail = "shamil@abdullin.ru shamil@abdullin.ru";
        isMailAdress = mail.matches("\\w+@\\w+.(ru|com)");
        System.out.println(isMailAdress);

        String poem = "Программный код творишь,\n"
                + "Опутан проводами,\n"
                + "Замученный делами,\n"
                + "День ты и ночь сидишь.\n"
                + "Разблокировать систему,\n"
                + "Алгоритм какой создать —\n"
                + "В своем деле просто гений!\n"
                + "Он не умеет отдыхать!\n"
                + "Комп сейчас ты отодвинь!";

        String[] parts = poem.split(" ");
        System.out.println(Arrays.toString(parts));

    }

    public static void replaceAll() {
        String message = "Privet!    Kak    dela?           Ok     !";
        System.out.println(message);
        String newMessage = message.replaceAll(" {2,}", " ");
        System.out.println(newMessage);
        line();

        newMessage = message.replaceFirst("\\bO\\w+", "Norm");
        System.out.println(newMessage);
    }

    public static void groupEx() {
        String cardFullInfo = "12345678912345670423777;65415678123345670423665;12789678456445670423789";
        // 04/23 1234 5678 9123 4567 (789)
        Pattern cardFormat = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = cardFormat.matcher(cardFullInfo);
        String newCardFormat = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println(newCardFormat);
        line();

        matcher.reset();
        while (matcher.find()) {
            System.out.println(matcher.group(7));
        }
        line();
    }

    public static void printFAndFormatEx() {
        String rawMessage = "My name is: %s, I have money: %,.2f, and I'am is a man: %b, and me %05d age.";
        String name = "Shamil";
        double money = 777_777.99;
        boolean isMale = true;
        int age = 31;

        System.out.printf(rawMessage, name, money, isMale, age);
        System.out.println();
        String newRow = String.format(rawMessage, name, money, isMale, age);
        System.out.println(newRow);
    }
}
