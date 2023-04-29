package com.shamilabd.comparator;

import java.util.*;

import static com.shamilabd.Utils.line;

public class ComparatorEx {
    public static void main(String[] args) {
        // Interface Comparator, method int compare(T var1, T var2);

        Cat cat1 = new Cat("Myrka", 5);
        Cat cat2 = new Cat("Merkyrii", 2);
        Cat cat3 = new Cat("Uazik", 99);
        Cat cat4 = new Cat("Tom", 7);
        Cat cat5 = new Cat("Ada", 4);

        List<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        System.out.println("Initialized order:");
        System.out.println(cats);
        line();

//        Collections.sort(cats); // can't call because we don't implement comparable

        System.out.println("Order by weight:");
        Collections.sort(cats, new Comparator<Cat>() { // use anonymous class
            @Override
            public int compare(Cat cat1, Cat cat2) {
                return cat1.getWeight() - cat2.getWeight();
            }
        });
        System.out.println(cats);
        line();

        System.out.println("Order by name:");
        //Collections.sort(cats, (c1, c2) -> c1.getName().compareTo(c2.getName())); // use lambda
        Collections.sort(cats, Comparator.comparing(Cat::getName));
        System.out.println(cats);
        line();
    }
}

class Cat {
    private String name;
    private int weight;

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat{"
                + getName()
                + ", "
                + getWeight()
                + " kg}";
    }
}


