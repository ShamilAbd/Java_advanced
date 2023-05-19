package com.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 18.05.2023
 */
public class SleepAndJoin {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(200);
        }
        System.out.println("Finish!");

        JoinExThread joinExThread1 = new JoinExThread();
        JoinExThread joinExThread2 = new JoinExThread();
        joinExThread1.start();
        joinExThread2.start();
        // далее принуждаем поток подождать завершение нижеуказанных потоков
        joinExThread1.join(450); // can throw InterruptedException
        joinExThread2.join(450);
        System.out.println("Main is end");
    }
}

class JoinExThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500); // метод run не может кидать исключений :-(
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}