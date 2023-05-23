package com.shamilabd.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
// есть еще AtomicBoolean, AtomicLong и еще несколько классов
public class AtomicIntegerEx {
    public static void main(String[] args) throws InterruptedException {
        notAtomicVersion();
        atomicVersion();
    }

    public static void notAtomicVersion() throws InterruptedException {
        Thread thread1 = new Thread(new NotAtomicIncrement());
        Thread thread2 = new Thread(new NotAtomicIncrement());
        Thread thread3 = new Thread(new NotAtomicIncrement());
        Thread thread4 = new Thread(new NotAtomicIncrement());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(OldIncrementVersion.counter);
    }

    public static void atomicVersion() throws InterruptedException {
        Thread thread1 = new Thread(new AtomicIncrement());
        Thread thread2 = new Thread(new AtomicIncrement());
        Thread thread3 = new Thread(new AtomicIncrement());
        Thread thread4 = new Thread(new AtomicIncrement());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(NewIncrementVersion.counter.get());
    }
}

class OldIncrementVersion {
    public static volatile int counter = 0;

    // без synchronized не атомарно, идет data racing
    public static void increment() {
        counter++;
    }
}

class NotAtomicIncrement implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            OldIncrementVersion.increment();
        }
    }
}

class NewIncrementVersion {
    public static AtomicInteger counter = new AtomicInteger();

    public static void increment() {
//        counter.addAndGet(5);
//        counter.getAndAdd(5);
//        counter.decrementAndGet();
//        counter.getAndDecrement();
        counter.incrementAndGet();
    }
}

class AtomicIncrement implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            NewIncrementVersion.increment();
        }
    }
}