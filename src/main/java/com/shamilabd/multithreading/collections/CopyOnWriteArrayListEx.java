package com.shamilabd.multithreading.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.05.2023
 */
public class CopyOnWriteArrayListEx {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            source.add(i);
        }
        List<Integer> target = new ArrayList<>();
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
