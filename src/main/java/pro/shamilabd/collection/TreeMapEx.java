package pro.shamilabd.collection;

import pro.shamilabd.comparable.Cat;

import java.util.TreeMap;
import static pro.shamilabd.Utils.line;

public class TreeMapEx {
    public static void main(String[] args) {
        simpleTreeMapTest();
    }

    private static void simpleTreeMapTest() {
        /*
        Хранится в самобалансируемом красно-черном дереве,
        в отсортированном порядке.
        O(log N)
         */
        TreeMap<Integer, pro.shamilabd.comparable.Cat> cats = new TreeMap<>(); // key must implement Comparable
        pro.shamilabd.comparable.Cat cat1 = new pro.shamilabd.comparable.Cat("Myrka", "W", 4);
        pro.shamilabd.comparable.Cat cat2 = new pro.shamilabd.comparable.Cat("Cat2", "m", 6);
        pro.shamilabd.comparable.Cat cat3 = new pro.shamilabd.comparable.Cat("NotDog", "M", 3);
        pro.shamilabd.comparable.Cat cat4 = new pro.shamilabd.comparable.Cat("Shoma", "M", 7);
        pro.shamilabd.comparable.Cat cat5 = new pro.shamilabd.comparable.Cat("May-may", "W", 15);
        pro.shamilabd.comparable.Cat cat6 = new pro.shamilabd.comparable.Cat("Gav", "W", 9);
        cats.put(1, cat1);
        cats.put(2, cat2);
        cats.put(3, cat3);
        cats.put(4, cat4);
        cats.put(5, cat5);
        cats.put(6, cat6);

        System.out.println(cats);
        line();
        System.out.println(cats.get(4));
        line();
        cats.remove(3);
        System.out.println(cats);
        line();
        System.out.println(cats.descendingMap());
        line();
        System.out.println(cats.tailMap(4)); // key include
        line();
        System.out.println(cats.headMap(5)); // key not include
        line();
        System.out.println(cats.firstEntry());
        line();
        System.out.println(cats.lastEntry());
        line();

        pro.shamilabd.comparable.Cat likeCat1 = new Cat("Myrka", "W", 4);
        System.out.println(cats.containsKey(2)); // must implement Comparable
        System.out.println(cats.containsValue(likeCat1)); // in Cat equals not override :(
        System.out.println(cats.containsValue(cat1));
    }
}
