package com.shamilabd.multithreading.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.05.2023
 */
public class ConcurrentMapEx {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>(); // есть CopyOnWriteArraySet
        names.add("Anna");
        names.add("Dima");
        names.add("Katya");
        names.add("Shoma");
        names.add("Yana");

        Runnable showMap = () -> {
            Iterator<String> iterator = names.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };
        Runnable addItem = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            names.remove(4);
            names.add("Juli");
        };

        Thread thread1 = new Thread(showMap);
        Thread thread2 = new Thread(addItem);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(names);
    }
}
