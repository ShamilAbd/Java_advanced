package com.shamilabd.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 02.05.2023
 */
public class LinkedListStudy {
    public static void main(String[] args) {
        //simpleLinkedList();
        listAsQueue();
    }

    private static void listAsQueue() {
        Queue<String> persons = new LinkedList<>();
        persons.add("Shoma");
        persons.add("Vasya");
        persons.add("Katya"); // в огран. очереди кидает исключение
        persons.offer("Dima"); // в огран. очереди НЕ кидает исключение
        persons.offer("Olya");
        System.out.println(persons);
        line();
        System.out.println(persons.element()); // кидает исключения
        System.out.println(persons.remove());
        System.out.println(persons);
        line();
        System.out.println(persons.peek()); // не кидает исключения
        System.out.println(persons.remove());
        System.out.println(persons);
        line();
        System.out.println(persons.remove());
        System.out.println(persons);
        line();
        System.out.println(persons.poll());
        System.out.println(persons);
        line();
        System.out.println(persons.remove());
        System.out.println(persons);
        line();
//        System.out.println(persons.remove()); // NoSuchElementException
//        System.out.println(persons);
//        line();
        System.out.println(persons.poll()); // не кидает исключения
        System.out.println(persons);
        line();
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
