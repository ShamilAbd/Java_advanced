package com.shamilabd.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 01.05.2023
 */
public class CollectionStudy {
    public static void main(String[] args) {
        arrayListStudy();
    }

    public static void hierarhy() {
        /*
        Interfaces:
             Iterable
             Collection
        List  Queue  Set       |         Map
         */
    }

    public static void arrayListStudy() {
        // array Object
        // DEFAULT_CAPACITY = 10;
        // initial ways
        ArrayList<String> test1 = new ArrayList<>();
        ArrayList<String> test2 = new ArrayList<>(777);
        List<String> otherList = new LinkedList<>();
        otherList.add(":-)");
        ArrayList<String> test3 = new ArrayList<>(otherList);

        // let's see
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        line();
        System.out.println(test1.size());
        System.out.println(test2.size());
        System.out.println(test3.size());
        line();

        test1.add("Abdullin");
        test1.add("Shamil");
        test1.add("Il'dusovich");
        test1.add("Java");
        System.out.println(test1); // Хранит порядок добавления элементов
        line();

        // methods:
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Kotlin");
        arrayList.add(0, "Languages"); // Ок
//        arrayList.add(5, "PHP"); // IndexOutOfBoundsException
        System.out.println(arrayList);
        line();

        System.out.println(arrayList.get(1));
        line();

        arrayList.set(2, "Delphi"); // update Kotlin to Delphi
        System.out.println(arrayList.get(2));
        line();

        System.out.println("Before remove by index:");
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println("After remove:");
        System.out.println(arrayList);
        line();

        System.out.println("Before remove by object:");
        System.out.println(arrayList);
        arrayList.remove("Java"); // Equals должен быть переопределен!
        System.out.println("After remove:");
        System.out.println(arrayList);
        line();

        otherList.add("Other List");
        System.out.println(otherList);
        arrayList.addAll(otherList);
//        arrayList.addAll(0, otherList); // add at position
        System.out.println(arrayList);
        line();

        arrayList.add("Java");
        arrayList.add("Abdullin");
        arrayList.add("Shamil");
        arrayList.add("Java");
        arrayList.add("Il'dusovich");
        arrayList.add("Java");
        System.out.println(arrayList);
        System.out.println(arrayList.indexOf("Other List"));
        System.out.println(arrayList.indexOf(":-(")); // not found: -1
        System.out.println(arrayList.indexOf("Java"));
        System.out.println(arrayList.lastIndexOf("Java"));
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("Shamil"));
        line();

        arrayList.clear();
        System.out.println(arrayList);
        line();

        arrayList.add("Abdullin");
        arrayList.add("Shamil");
        arrayList.add("Java");
        arrayList.add("Il'dusovich");
        arrayList.add("Java");
        arrayList.add("Dima");
        arrayList.add("Anna");
        System.out.println(arrayList);
        line();
        arrayListStudyEnd();
    }

    public static void arrayListStudyEnd() { // because admissible max 100 lines in method
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> test2 = new ArrayList<>();
        test2.add("Java");
        test2.add("Dima");
        test2.add("Anna");
        arrayList.removeAll(test2);
        System.out.println(arrayList);
        line();

        arrayList.add("Katya");
        arrayList.add("Dima");
        arrayList.add("Java");
        arrayList.add("Anna");
        arrayList.add("Java");
        arrayList.retainAll(test2);
        System.out.println(arrayList);
        line();

        System.out.println(arrayList);
        System.out.println(test2);
        System.out.println(arrayList.containsAll(test2));
        line();

        List<String> subList = arrayList.subList(1, 3); // 3 not include in this VIEW !!!
        System.out.println(subList);

        subList.add("Fedor");
        System.out.println(subList);
        System.out.println(arrayList); // connected
        arrayList.add("Problem element");
        System.out.println(arrayList);
//        System.out.println(subList); // ConcurrentModificationException :-(
        line();

        Object[] fromList = arrayList.toArray();
        System.out.println(Arrays.toString(fromList));
        line();

        String[] fromList2 = arrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(fromList2));
        line();

        List<String> simpleListOf = List.of("One", "Two", "Hello"); // null - can't write here
        System.out.println(simpleListOf);
//        simpleListOf.add("New string"); // UnsupportedOperationException
//        System.out.println(simpleListOf);
        line();

        List<String> copyEx = List.copyOf(arrayList);
        System.out.println(copyEx);
//        copyEx.add("Problem"); // UnsupportedOperationException
        System.out.println(copyEx);
    }

}
