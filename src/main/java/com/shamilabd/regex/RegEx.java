package com.shamilabd.regex;

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
}
