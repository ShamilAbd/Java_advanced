package com.shamilabd.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static com.shamilabd.Utils.line;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 05.05.2023
 */
public class MapEx {
    public static void main(String[] args) {
//        simpleMapEx();
        mapWithCustomClass();
    }

    private static void mapWithCustomClass() {
        Map<Dog, Cat> pets = new HashMap<>();
        pets.put(new Dog("Pit", 12), new Cat("Murka", 5));
        pets.put(new Dog("K9", 7), new Cat("Vaska", 7));
        pets.put(new Dog("Bul", 5), new Cat("Azaliya", 3));
        pets.put(new Dog("Pushistik", 9), new Cat("Murzik", 6));

        System.out.println(pets);
        line();

        System.out.println(pets.get(new Dog("Pit", 12))); // check equals and hashCode
        line();
    }

    private static void simpleMapEx() {
        Map<Integer, String> simpleMap = new HashMap<>();
        simpleMap.put(0, "Anna");
        simpleMap.put(2, "Dima");
        simpleMap.put(5, "Katya");
        simpleMap.put(777, "Shoma");
        simpleMap.put(-3, "Vasya");
        simpleMap.put(0, "Petya"); // has been rewritten Anna;
        simpleMap.put(-4, "Tanya");
        simpleMap.put(-11, "Myaso");
        simpleMap.put(null, "null"); // null in key is allowed
        simpleMap.put(null, "null_2"); // only one null
        simpleMap.put(6, null); // null in value is allowed
        simpleMap.put(7, null);

        // hashmap not sorted
        System.out.println(simpleMap);
        line();

        simpleMap.putIfAbsent(777, "Ne Shoma");
        System.out.println(simpleMap); // still 777 is Shoma
        line();

        simpleMap.remove(-4);
        System.out.println(simpleMap);
        line();
        simpleMap.remove(-3, "Myaso"); // not found, not removed
        System.out.println(simpleMap);
        line();
        simpleMap.remove(-3, "Vasya"); // removed
        System.out.println(simpleMap);
        line();
        System.out.println(simpleMap.containsValue("Dima"));
        System.out.println(simpleMap.containsValue("Ololo"));
        line();
        System.out.println(simpleMap.containsKey(6));
        System.out.println(simpleMap.containsKey(666));
        line();

        Set<Integer> keys = simpleMap.keySet();
        System.out.println(keys);
        line();

        Collection<String> names = simpleMap.values();
        System.out.println(names);
        line();
    }
}

class Dog {
    @NotNull
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Dog dog = (Dog) o;

        if (age != dog.age) {
            return false;
        }
        return name.equals(dog.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return 31 * result + age;
    }

    @Override
    public String toString() {
        return "Dog{" + name + ", age=" + age + '}';
    }
}