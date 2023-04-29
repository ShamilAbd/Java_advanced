package com.shamilabd.generics;

import java.util.ArrayList;
import java.util.Objects;

public class Wildcard {

    public static void main(String[] args) {
        ArrayList<?> test1 = new ArrayList<Integer>();
//        test1.add(1); // can't change wildcard object
        ArrayList<? extends Number> test2 = new ArrayList<Integer>();
//        test2.add(3); // can't
        ArrayList<? super Number> test3 = new ArrayList<Object>(); // Number and his parents

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(2);
        ints.add(3);
        ints.add(5);
        System.out.println(sumAnyList(ints));

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(2.3);
        doubles.add(3.4);
        doubles.add(5.88);
        System.out.println(sumAnyList(doubles));
    }

    public static double sumAnyList(ArrayList<? extends Number> numbers) {
        double summa = 0;
        for (Number number : numbers) {
            summa += number.doubleValue();
        }
        return summa;
    }
}
