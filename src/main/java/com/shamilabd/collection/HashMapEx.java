package com.shamilabd.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import static com.shamilabd.Utils.line;

public class HashMapEx {
    public static void main(String[] args) {
        simpleHashMap();
        simpleHashTable();
    }

    private static void simpleHashMap() {
//        Map<String, Double> planetWeight = new HashMap<>(9);
//        Map<String, Double> planetWeight = new HashMap<>(9, 0.9F);
        Map<String, Double> planetWeight = new HashMap<>();
        planetWeight.put("Earth", 777D);
        planetWeight.put("Mars", 666.6);
        planetWeight.put("Jupiter", 222.222);
        planetWeight.put("Pluto", 123.321);
        planetWeight.put("Venera", 0.3);
        planetWeight.put("Mercury", 159_753_147_852_369_874_521.1);
        planetWeight.put(null, 0.0000001);

        System.out.println(planetWeight);
        line();

        System.out.println(planetWeight.get("Mars"));
        line();
        System.out.println(planetWeight.size());
        line();
        System.out.println(planetWeight.hashCode());
        line();
        System.out.println(planetWeight.isEmpty());
        line();
        System.out.println(planetWeight.containsKey("Earth"));
        System.out.println(planetWeight.containsKey("Bubba"));
        line();
        System.out.println(planetWeight.remove("Pluto"));
        line();
    }

    private static void simpleHashTable() {
        // Like HashMap, but synchronized and can't contain null anywhere
        Hashtable<Integer, Integer> multiplier = new Hashtable<>();
        multiplier.put(1, 1);
        multiplier.put(2, 4);
        multiplier.put(3, 9);
        multiplier.put(4, 16);
        multiplier.put(5, 25);
        multiplier.put(6, 36);
        System.out.println(multiplier);
//        multiplier.put(null, 36); // NPE !!!
//        multiplier.put(7, null); // NPE !!!
    }
}
