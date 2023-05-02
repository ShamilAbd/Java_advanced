package com.shamilabd.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 02.05.2023
 */
public class LinkedListStudy {
    public static void main(String[] args) {
        simpleLinkedList();
    }

    /*
    LinkedList чаще используется когда количество операций запросов элементов не велико
    или Велико количество операций вставки или удаления элементов в начало или конец списка.
    Во всех остальных ситуациях обычно выигрывает ArrayList
     */
    private static void simpleLinkedList() {
        List<String> names = new LinkedList<>();
        names.add("Anna");
        names.add("Katya");
        names.add("Dima");
        names.add("Vasya");
        names.add("Shoma");
        names.add("Yana");

        List<String> arrayList = new ArrayList<>();
        arrayList.add("Abdullin");
        arrayList.add("Shamil");
        arrayList.add("Il'dusovich");
        List<String> namesFromArray = new LinkedList<>(arrayList);

        System.out.println(names.get(3));
    }
}
