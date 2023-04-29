package com.shamilabd.generics.example;

public class Schoolar extends Player implements Comparable {
    public Schoolar(String name, int age) {
        super(name, age);
    }

    @Override
    public int compareTo(Object o) {
        return 0; // dummy
    }
}
