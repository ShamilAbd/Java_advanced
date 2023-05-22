package com.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 21.05.2023
 */
public class DeadLockEx {
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        LockEx1 lockEx1 = new LockEx1();
        LockEx2 lockEx2 = new LockEx2();
        lockEx1.start();
        lockEx2.start();
    }

    public void someMethod1(int tryNumber) {
        System.out.println("Method1: " + tryNumber);
        System.out.println("Method1: Try to lock1");
        synchronized (LOCK1) {
            System.out.println("Method1: lock1 locked");
            System.out.println("Method1: try to lock2");
            synchronized (LOCK2) {
                System.out.println("Method1: lock2 locked");
            }
        }
        System.out.println("Method1:exit from method 1");
    }

    public void someMethod2(int tryNumber) {
        System.out.println("Method2: " + tryNumber);
        System.out.println("Method2: Try to lock2");
        synchronized (LOCK2) { // Need use LOCK1
            System.out.println("Method2: lock2 locked");
            System.out.println("Method2: try to lock1");
            synchronized (LOCK1) { // Need use LOCK2
                System.out.println("Method2: lock1 locked");
            }
        }
        System.out.println("Method2:exit from method 2");
    }
}

class LockEx1 extends Thread {
    @Override
    public void run() {
        DeadLockEx dl = new DeadLockEx();
        for (int i = 0; i < 100; i++) {
            dl.someMethod1(i);
        }
    }
}

class LockEx2 extends Thread {
    @Override
    public void run() {
        DeadLockEx dl = new DeadLockEx();
        for (int i = 0; i < 100; i++) {
            dl.someMethod2(i);
        }
    }
}