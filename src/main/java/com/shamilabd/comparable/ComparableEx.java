package com.shamilabd.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.shamilabd.Utils.*;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.04.2023
 */
public class ComparableEx {
    public static void main(String[] args) {
//        simpleExample();
//        catExample();
        dogExample();
    }

    public static void simpleExample() {
        List<String> names = new ArrayList<>();
        names.add("Katya");
        names.add("Sasha");
        names.add("Petya");
        names.add("Vika");
        names.add("Dima");
        names.add("Enokentii");
        names.add("Shamil");

        System.out.println("Before sort:");
        System.out.println(names);
        line();
        Collections.sort(names); // natural order
        System.out.println("After sort:");
        System.out.println(names);
        line();
        System.out.println("Sort by string length:");
        names.sort((f, s) -> f.length() - s.length()); // used func interface Comparator, int compare(T o1, T o2);
        //names.sort(Comparator.comparingInt(String::length)); // TODO: разобраться, как это работает.
        System.out.println("After my sort:");
        System.out.println(names);
    }

    public static void catExample() {
        Cat cat1 = new Cat("Angel", "male", 7.3);
        Cat cat2 = new Cat("Devil", "female", 5.4);
        Cat cat3 = new Cat("Angel", "male", 7.3); // twin cat1
        Cat cat4 = new Cat("Jack", "male", 6.1);
        Cat cat5 = new Cat("Шамиль", "male", 4.5);
        Cat cat6 = new Cat("Алиса", "female", 6.6);

        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        cats.add(cat6);

        System.out.println("Before sort:");
        System.out.println(cats);
        line();
        System.out.println("After sort:");
//        Collections.sort(cats); // we can't call sort on Cat, because we don't implement Comparable
        // but, we can use lambda for compare
        cats.sort((f, s) -> (int) ((f.getWeight() - s.getWeight()) * 10)); // scale up to 10, because we have small nums
        System.out.println(cats);
        line();
    }

    public static void dogExample() {
        Dog dog1 = new Dog("Angel", "male", 7.3);
        Dog dog2 = new Dog("Devil", "female", 5.4);
        Dog dog3 = new Dog("Angel", "female", 7.3); // almost twin Dog1
        Dog dog4 = new Dog("Jack", "male", 6.1);
        Dog dog5 = new Dog("Шамиль", "male", 4.5);
        Dog dog6 = new Dog("Алиса", "female", 6.6);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
        dogs.add(dog6);

        System.out.println("Before sort:");
        System.out.println(dogs);
        line();
        System.out.println("After sort:");
        Collections.sort(dogs); // we can call sort on Dog, because we implement Comparable
        // and also we can use lambda for compare
        //dogs.sort((f, s) -> (int) ((f.getWeight() - s.getWeight()) * 10)); // scale up to 10, because we have small nums
        System.out.println(dogs);
        line();
    }
}
