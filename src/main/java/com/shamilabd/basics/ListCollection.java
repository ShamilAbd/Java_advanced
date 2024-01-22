package com.shamilabd.basics;

import com.shamilabd.elementary.Utils;

import java.util.*;

import static com.shamilabd.basics.ArraysStudy.showArray;
import static com.shamilabd.elementary.Utils.line;
/**
 * @author Abdullin Shamil Ildusovich
 * @Date 17.04.2023
 */
public class ListCollection {
    static List list;
    public static void main(String[] args) {
        /* Hierarchy
        1) Iterable
        2) Collection
        3) List
         */
        ArrayListLearning();
//        LinkedListLearning();
//        VectorListLearning();
//        StackListLearning();
    }

    public static void ArrayListLearning() {
        studyingListName("ArrayList");
        // ways to initialize
        List<String> arrayList = new ArrayList<>(); // NOT thread save
        List<String> arrayList2 = new ArrayList<>(10); // Default 10
        List<String> arrayList3 = new ArrayList<>(arrayList); // from other list

        list = arrayList; // для простоты вывода грубо присвоим полю класса

        arrayList.add("Hello");
        arrayList.add("List ");
        arrayList.add("Implementation. ");
        arrayList.add(1,", ");
        showList(); // Для простоты не буду мудрить с выводом слов через пробел, просто буду добавлять его в сами строки
        Utils.line(true);

        String[] strs = arrayList.toArray(new String[0]);
        showArray(strs);
        Utils.line();

        List<String> otherList = new ArrayList<>();
        otherList.add("other ");
        otherList.add("List ");
        otherList.add("values ");
        arrayList.addAll(otherList);
        showList();
        Utils.line(true);

        arrayList.clear();
        showList();
        Utils.line(true);

        arrayList.add("Hello");
        arrayList.add("List ");
        arrayList.add("Implementation.");
        arrayList.add(1,", ");
        System.out.println(arrayList.contains("Hello"));
        System.out.println(arrayList.contains(new String("Hello"))); // equals override
        Utils.line();


        otherList.clear();
        otherList.add("Hello");
        otherList.add("List ");
        System.out.println(arrayList.containsAll(otherList));
        Utils.line();

        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.hashCode());
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.indexOf("List "));
        Utils.line();

        System.out.println("Before sorting");
        arrayList.add("As");
        showList();
//        arrayList.sort(Comparator.comparingInt(String::length)); // можно так, но пока не понимаю такой вызов
        arrayList.sort((e, t)->(e.length()-t.length()));
        System.out.println();
        System.out.println("After sorting");
        showList();
        Utils.line(true);

        System.out.println(arrayList.remove("Hello"));
        showList();
        Utils.line(true);

        Iterator<String> arrIter = arrayList.iterator();
        while (arrIter.hasNext()){
            String str = arrIter.next();
            System.out.println("Next element: " + str);
        }
        line();

        arrayList.add("List");
        arrayList.add("Ball");
        arrayList.add("777");
        arrayList.add("Was");
        arrayList.add("new");
        arrayList.add("array");
        System.out.println("Before sort:");
        showList();
        System.out.println();
        System.out.println("After sort:");
        Collections.sort(arrayList);
        showList();
        line(true);


        showList();
        System.out.println();
        arrayList.set(3, "Vasya"); // replace value
        showList();
        line(true);

        list = Arrays.asList(1,2,3,5,10);
        showList();
        line(true);
    }

    public static void LinkedListLearning() {
        studyingListName("LinkedList");
        // ways to initialize
        List<String> linkedList = new LinkedList<>(); // NOT thread save
        List<String> linkedList4 = new LinkedList<>(linkedList); // from other list

        list = linkedList; // для простоты вывода грубо присвоим полю класса

        linkedList.add("Hello");
        linkedList.add("List ");
        linkedList.add("Implementation. ");
        linkedList.add(1,", ");
        showList(); // Для простоты не буду мудрить с выводом слов через пробел, просто буду добавлять его в сами строки
        line(true);

        String[] strs = linkedList.toArray(new String[0]);
        showArray(strs);
        line();

        List<String> otherList = new LinkedList<>();
        otherList.add("other ");
        otherList.add("List ");
        otherList.add("values ");
        linkedList.addAll(otherList);
        showList();
        line(true);

        linkedList.clear();
        showList();
        line(true);

        linkedList.add("Hello");
        linkedList.add("List ");
        linkedList.add("Implementation.");
        linkedList.add(1,", ");
        System.out.println(linkedList.contains("Hello"));
        System.out.println(linkedList.contains(new String("Hello"))); // equals override
        line();


        otherList.clear();
        otherList.add("Hello");
        otherList.add("List ");
        System.out.println(linkedList.containsAll(otherList));
        line();

        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.hashCode());
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.indexOf("List "));
        line();

        System.out.println("Before sorting");
        linkedList.add("As");
        showList();
//        linkedList.sort(Comparator.comparingInt(String::length)); // можно так, но пока не понимаю такой вызов
        linkedList.sort((e, t)->(e.length()-t.length()));
        System.out.println();
        System.out.println("After sorting");
        showList();
        line(true);

        System.out.println(linkedList.remove("Hello"));
        showList();
        line(true);

        Iterator<String> arrIter = linkedList.iterator();
        while (arrIter.hasNext()){
            String str = arrIter.next();
            System.out.println("Next element: " + str);
        }
        line();
    }

    public static void VectorListLearning() {
        studyingListName("Vector");
        // Все тоже самое что и у ArrayList
        // ways to initialize
        List<String> vectorList = new Vector<>(); // NOT thread save
        List<String> vectorList2 = new Vector<>(10); // Default 10
        List<String> vectorList3 = new Vector<>(10,15); // Default 10
        List<String> vectorList4 = new Vector<>(vectorList); // from other list

        vectorList.add("This is vector");
        list = vectorList; // для простоты вывода грубо присвоим полю класса

        showList();
        line(true);
    }

    public static void StackListLearning() {
        studyingListName("Stack");
        // Все тоже самое что и у ArrayList
        // ways to initialize
        Stack<String> stackList = new Stack<>(); // NOT thread save

        stackList.add("This is 1 element");
        stackList.add("This is 2 element");
        stackList.add("This is 3 element");
        stackList.add("This is 4 element");
        stackList.add(2, "This is 5 element");
        stackList.add("This is 6 element");
        list = stackList; // для простоты вывода грубо присвоим полю класса
        showList();
        line(true);

        System.out.println(stackList.push("Val 1"));
        System.out.println(stackList.push("Val 2"));
        System.out.println(stackList.pop()); // reverse order: Val 2, Val 1, This is 6 element and etc
        System.out.println(stackList.pop());
        System.out.println(stackList.pop());
        System.out.println(stackList.peek());
        System.out.println(stackList.peek()); // again same object!
        showList(); // This is 4 element is not removed
        line(true);
    }

    public static void showList() {
        list.forEach(e-> System.out.print(e));
    }

    public static void studyingListName(String name) {
        System.out.println("*************************************");
        System.out.println(name + " studying");
        System.out.println("*************************************");
    }

}
