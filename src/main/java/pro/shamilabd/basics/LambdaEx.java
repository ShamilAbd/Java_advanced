package pro.shamilabd.basics;

import pro.shamilabd.elementary.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static pro.shamilabd.elementary.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 22.04.2023
 */
public class LambdaEx {
    public static void main(String[] args) {
        firstExample();
    }

    public static void firstExample() {
        List<String> names = new ArrayList<>();
        names.add("SHamil");
        names.add("Shamil");
        names.add("Vasya");
        names.add("Katya");
        names.add("Gulnara");
        names.add("Anna");

        System.out.println(names);
        Utils.line();
        names.sort((String f, String s) -> {
            return f.length() - s.length();
        }); // full notation
        System.out.println(names);
        Utils.line();
        names.sort((f, s) -> f.charAt(0) - s.charAt(0)); // almost short notation
        System.out.println(names);
        Utils.line();
        names.removeIf(e -> e.equals("Anna"));
        System.out.println(names);
        Utils.line();
        names.forEach(c -> System.out.println(c + " is good men"));
        Utils.line();

        showMatched(names, e -> e.endsWith("a")); // short notation
        Utils.line();
    }

    public static void showMatched(List<String> list, Predicate<String> condition) {
        for (String str : list) {
            if (condition.test(str)) {
                System.out.println(str);
            }
        }
    }
}
