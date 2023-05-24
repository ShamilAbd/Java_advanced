package com.shamilabd.multithreading.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.05.2023
 */
public class SynchronizedCollEx {
    public static void main(String[] args) throws InterruptedException {
//        simpleExample();
        concurrentModifExepExample();
    }

    public static void simpleExample() throws InterruptedException {
        List<Integer> source = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            source.add(i);
        }

//        List<Integer> target = new ArrayList<>(); // not synchronized collection
        List<Integer> target = Collections.synchronizedList(new ArrayList<>());
        Runnable fillingList = () -> {
            target.addAll(source);
        };
        Thread thread1 = new Thread(fillingList);
        Thread thread2 = new Thread(fillingList);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(target);
    }

    public static void concurrentModifExepExample() throws InterruptedException {
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            source.add(i);
        }
        List<Integer> target = Collections.synchronizedList(source);
        Runnable showList = () -> {
            synchronized (target) {
                Iterator<Integer> iterator = target.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        Runnable removeElement = () -> {
          target.remove(10);
        };
        Thread thread1 = new Thread(showList);
        Thread thread2 = new Thread(removeElement);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(target);
    }
}
