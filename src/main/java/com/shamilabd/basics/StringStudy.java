package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

import static com.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 13.04.2023
 */
public class StringStudy {
    public static void main(String[] args) {
        // String is final class, Serializable, Comparable, CharSequence, Constable, ConstantDesc
        //

        String str1 = "Hello World!"; // Object in string pool
        String str2 = "Hello World!"; // same object
        String str3 = "hello world!"; // new object
        System.out.println("str1 == str2 ? " + (str1 == str2));
        System.out.println("str1.equals(str2) ? " + (str1.equals(str2)));
        System.out.println("str1 == str3 ? " + (str1 == str3));
        System.out.println("str1.equals(str3) ? " + str1.equals(str3));
        System.out.println("str1.equalsIgnoreCase(str3) ? " + str1.equalsIgnoreCase(str3));
        Utils.line();

        String obj1 = new String("FromNewString"); // new object
        String obj2 = new String("FromNewString"); // new object
        String obj3 = new String("fromnewstring"); // new object
        System.out.println("obj1 == obj2 ? " + (obj1 == obj2));
        System.out.println("obj1.equals(obj2) ? " + (obj1.equals(obj2)));
        System.out.println("obj1 == obj3 ? " + (obj1 == obj3));
        System.out.println("obj1.equals(obj3) ? " + obj1.equals(obj3));
        System.out.println("obj1.equalsIgnoreCase(obj3) ? " + obj1.equalsIgnoreCase(obj3));
        Utils.line();
        Utils.line();

        System.out.println(str1);
        System.out.println(str1.length());
        System.out.println(str1.charAt(4));
        Utils.line();

        System.out.println(Arrays.toString(str1.getBytes(StandardCharsets.US_ASCII)));
        System.out.println(Arrays.toString(str1.getBytes()));
        Utils.line();

        System.out.println(str1.toLowerCase());
        System.out.println(str1.toLowerCase(Locale.ENGLISH));
        System.out.println(str1.toUpperCase());
        Utils.line();

        System.out.println(Arrays.toString(str1.split("\\s+")));
        System.out.println(str1.concat(str3));
        System.out.println(str1.startsWith("Hell"));
        System.out.println(str1.endsWith("!"));
        System.out.println(str1.hashCode());
        System.out.println(str1.indent(3)); // отступ
        Utils.line();

        System.out.println(str1.indexOf('e'));
        System.out.println(str1.indexOf("e"));
        System.out.println(str1.indexOf(101));
        Utils.line();

        System.out.println(str1.lastIndexOf('l'));
        System.out.println(str1.lastIndexOf('l', 9));
        System.out.println(str1.lastIndexOf('l', 10));
        System.out.println(str1.lastIndexOf("l", 5));
        System.out.println(str1.lastIndexOf(108));
        Utils.line();

        obj1 = "";
        obj2 = "   ";
        System.out.println(obj1.isBlank()); // true
        System.out.println(obj1.isEmpty()); // true;
        System.out.println(obj2.isBlank()); // true
        System.out.println(obj2.isEmpty()); // false
//        obj1 = null;
//        System.out.println(obj1.isBlank()); //NullPointerException
//        System.out.println(obj1.isEmpty()); //NullPointerException
        line();

        obj1 = "  Some other text ";
        System.out.println(obj1);
        System.out.println(obj1.trim());
        System.out.println(obj1.substring(7));
        System.out.println(obj1.substring(4, 12));
        System.out.println(obj1.replace('x', 'S'));
        System.out.println(obj1.replace("ome", "ake")); // String implements CharSequence
        System.out.println(obj1.replaceAll("\\s+", "_"));
        System.out.println(obj1.replaceFirst("\\s+", "_"));
        line();

        obj1 = "It's beautiful ";
        obj2 = "world!";
        System.out.println(obj1 + obj2);
        line();

        int a = 5;
        int b = 7;
        System.out.println(obj1 + a + b); // concat as word
        System.out.println(obj1 + (a + b)); // added before +
        line();

        // method chaining
        obj2 = " My";
        obj2 = obj2.concat(" name is Petya!  ").replace("Petya", "Shamil").trim();
        System.out.println(obj2);
        line();

        // Practice
        String poem = "Добрая душа" +
                "Я малышей люблю от всей души." +
                "За что? За то, что это – малыши." +
                "Люблю и великана всей душой." +
                "За что? За то, что он такой большой." +
                "В. Берестов";
        System.out.println("Before:");
        System.out.println(poem);
        line();

        System.out.println("After:");
        String poemUpperCase = poem.toUpperCase();
        char poemChar;
        for (int i = 0; i < poem.length(); i++) {
            poemChar = poem.charAt(i);
            if (poemChar == poemUpperCase.charAt(i) && poemChar > 1040 && poemChar < 1103)
                System.out.println();
            System.out.print(poem.charAt(i));
        }
    }
}
