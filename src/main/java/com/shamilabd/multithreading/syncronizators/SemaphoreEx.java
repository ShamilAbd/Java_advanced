package com.shamilabd.multithreading.syncronizators;

import java.util.concurrent.Semaphore;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class SemaphoreEx {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Caller("Саша"));
        Thread thread2 = new Thread(new Caller("Петя"));
        Thread thread3 = new Thread(new Caller("Катя"));
        Thread thread4 = new Thread(new Caller("Вася"));
        Thread thread5 = new Thread(new Caller("Шома"));
        Thread thread6 = new Thread(new Caller("Дима"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        System.out.println("Main is end");
    }
}

class Caller implements Runnable {
    private String name;
    private static final Semaphore SEMAPHORE = new Semaphore(2);

    public Caller(String name) {
        this.name = name;
    }

    public void talk() {
        try {
            System.out.println(name + " пытается начать говорить по телефону");
            SEMAPHORE.acquire();
            System.out.println(name + " разговаривает...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " договорил");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            SEMAPHORE.release();
        }
    }

    @Override
    public void run() {
        talk();
    }
}