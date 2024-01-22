package pro.shamilabd.collection;

import java.util.TreeSet;
import static pro.shamilabd.Utils.line;

public class TreeSetEx {
    public static void main(String[] args) {
        // как и треемап, объект должен имплементировать компарабле или получать его в конструктор
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(4);
        set.add(3);
        set.add(6);
        set.add(7);
        set.add(9);
        set.add(8);
        set.add(0);
//        set.add(null); // NPE
        System.out.println(set); // sorted
        line();
        System.out.println(set.contains(2));
        System.out.println(set.contains(4));
        line();
        System.out.println(set.first());
        line();
        System.out.println(set.last());
        line();
        System.out.println(set.headSet(4)); // 4 not include
        line();
        System.out.println(set.tailSet(4));
        line();
        System.out.println(set.subSet(4, 6));
        line();
    }
}
