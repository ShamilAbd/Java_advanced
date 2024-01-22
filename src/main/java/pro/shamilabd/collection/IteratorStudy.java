package pro.shamilabd.collection;

import java.util.*;

import static pro.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 02.05.2023
 */
public class IteratorStudy {
    public static void main(String[] args) {
        simpleIterator();
        listIterator();
        System.out.println(isPolindrom("MADAM"));
        System.out.println(isPolindrom("MADDAM"));
        System.out.println(isPolindrom("MADADAM"));
        System.out.println(isPolindrom("MAdDAM"));
        System.out.println(isPolindrom("MADaDAM"));
        System.out.println(isPolindrom("MADaADAM"));
        System.out.println(isPolindrom("7MADAM7"));
        System.out.println(isPolindrom("1MADAM9"));
        System.out.println(isPolindrom("asdsa"));
    }

    public static void simpleIterator() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Katya");
        names.add("Dima");
        names.add("Vasya");
        names.add("Shoma");
        names.add("Yana");

        System.out.println(names);
        Iterator<String> nameIterator = names.iterator();
        while (nameIterator.hasNext()) {
            if (nameIterator.next() == "Dima") {
                nameIterator.remove();
            }
        }
        System.out.println(names);
        line();
    }

    public static void listIterator() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Katya");
        names.add("Dima");
        names.add("Vasya");
        names.add("Shoma");
        names.add("Yana");

        System.out.println(names);
        ListIterator<String> nameIterator = names.listIterator();
        while (nameIterator.hasNext()) {
            if (nameIterator.next() == "Dima") {
                nameIterator.remove();
            }
        }
        while (nameIterator.hasPrevious()) {
            if (nameIterator.previous() == "Shoma") {
                System.out.println("Aga!");
            }
        }
        System.out.println(names);
        line();
    }

    public static boolean isPolindrom(String word) {
        // Big O - N
        List<Character> charsForCompare = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            charsForCompare.add(ch);
        }

        Iterator<Character> directOrder = charsForCompare.iterator(); // 2 вида итератора только для "набивания" руки. Так везде бы использовал ListIterator
        ListIterator<Character> reverseOrder = charsForCompare.listIterator(charsForCompare.size());
        int halfWordSize = charsForCompare.size() / 2;

        // Big O - N/2
        while (directOrder.hasNext() && reverseOrder.hasPrevious()) {
            if (directOrder.next() != reverseOrder.previous()) {
                return false;
            }
            if (reverseOrder.nextIndex() <= halfWordSize) { // already checked
                return true;
            }
        }

        // Total Big O - N
        return true;
    }
}
