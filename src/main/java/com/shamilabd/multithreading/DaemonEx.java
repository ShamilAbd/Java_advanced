package com.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 22.05.2023
 */
public class DaemonEx {
    public static void main(String[] args) {
        System.out.println("Main start");
        NotDaemon notDaemon = new NotDaemon();
        Daemon daemon = new Daemon();
        notDaemon.start();
        daemon.setDaemon(true);
        daemon.start();
//        daemon.setDaemon(true); // IllegalThreadStateException
        System.out.println("Main end");
    }
}

class NotDaemon extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (char i = 'A'; i <= 'W'; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class Daemon extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}