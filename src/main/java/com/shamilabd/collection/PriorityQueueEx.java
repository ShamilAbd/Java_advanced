package com.shamilabd.collection;

import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> priority = new PriorityQueue<>();
        priority.add(4);
        priority.add(1);
        priority.add(6);
        priority.add(3);
        priority.add(2);
        priority.add(9);
        priority.add(3);
        System.out.println(priority);
        System.out.println(priority.remove());
        System.out.println(priority.remove());
        System.out.println(priority.remove());
        System.out.println(priority.remove());
        System.out.println(priority.remove());
        System.out.println(priority.remove());
        System.out.println(priority.remove());
//        System.out.println(priority.remove()); // NPE
        System.out.println(priority.poll());

    }
}
