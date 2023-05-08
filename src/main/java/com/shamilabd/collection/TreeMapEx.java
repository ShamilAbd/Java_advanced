package com.shamilabd.collection;

import com.shamilabd.comparable.Cat;
import java.util.TreeMap;
import static com.shamilabd.Utils.line;

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
        TreeMap<Integer, Cat> cats = new TreeMap<>(); // key must implement Comparable
        Cat cat1 = new Cat("Myrka", "W", 4);
        Cat cat2 = new Cat("Cat2", "m", 6);
        Cat cat3 = new Cat("NotDog", "M", 3);
        Cat cat4 = new Cat("Shoma", "M", 7);
        Cat cat5 = new Cat("May-may", "W", 15);
        Cat cat6 = new Cat("Gav", "W", 9);
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

        Cat likeCat1 = new Cat("Myrka", "W", 4);
        System.out.println(cats.containsKey(2)); // must implement Comparable
        System.out.println(cats.containsValue(likeCat1)); // in Cat equals not override :(
        System.out.println(cats.containsValue(cat1));
    }
}
