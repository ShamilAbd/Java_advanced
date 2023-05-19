package com.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 18.05.2023
 */
public class MultithreadingStart {
    public static void main(String[] args) throws InterruptedException {
        /*
        Context switch
        We can extend Thread or implement Runnable and override public void run()
         */
        SimpleThread simpleThread = new SimpleThread();
        OtherSimpleThread otherSimpleThread = new OtherSimpleThread();
        Thread thirdThread = new Thread(new ImplementedThread());
        Thread fourthThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class");
            }
        });
        Thread fifthMethod = new Thread(() -> System.out.println("Lambda thread"));

        simpleThread.start();
        otherSimpleThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthMethod.start();
//        simpleThread.join();
//        otherSimpleThread.join();
        System.out.println("Main method is done.");
    }
}

class SimpleThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class OtherSimpleThread extends Thread {
    @Override
    public void run() {
        for (int i = 1000; i >= 0; i--) {
            System.out.println(i);
        }
    }
}

class ImplementedThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println("Runnable - " + i);
        }
    }
}