package com.shamilabd.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class ThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {

    }
}

class FixedThreadEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImp());
        }
        executorService.shutdown();
        executorService.awaitTermination(6, TimeUnit.SECONDS);
        System.out.println("Main end");
    }
}

class RunnableImp implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start work");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + " end work");
    }
}

class ScheduledExecutorServiceEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
//        ses.schedule(new RunnableImp(), 3, TimeUnit.SECONDS); // start after 3 sec
//        ses.scheduleAtFixedRate(() -> {
//            System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis());
//            }, 3, 1, TimeUnit.SECONDS); // 1 - время между началами выполнения заданий
        ses.scheduleWithFixedDelay(new RunnableImp(), 3, 1, TimeUnit.SECONDS); // 1 - время между окончанием задания и началом следующего заданий
        Thread.sleep(16000);
        ses.shutdown();
        System.out.println("Main end");
    }
}