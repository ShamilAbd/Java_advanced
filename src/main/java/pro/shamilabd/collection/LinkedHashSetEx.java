package pro.shamilabd.collection;

import java.util.LinkedHashSet;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        // Хранит только порядок добавления. На основе HashMap
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(6);
        set.add(4);
        set.add(1);
        set.add(3);
        set.add(9);
        System.out.println(set);
    }
}
