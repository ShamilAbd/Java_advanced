package com.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 18.05.2023
 */
public class VolatileEx extends Thread {
    private volatile static boolean canContinue; // in main memory

    public static void main(String[] args) throws InterruptedException {
        canContinue = true;
        VolatileEx volatileEx = new VolatileEx();
        volatileEx.start();
        Thread.sleep(100);
        canContinue = false; // только для атомарных операций или для записи 1 потоком, иначе будет не консистентность данных
        volatileEx.join(); // не остановится, если volatile не указать.
    }

    public void run() {
        long counter = 0;
        while (canContinue) {
            counter++;
        }
        System.out.println("Loop is finished. Counter: " + counter);
    }
}
