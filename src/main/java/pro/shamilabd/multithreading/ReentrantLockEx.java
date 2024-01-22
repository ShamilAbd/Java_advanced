package pro.shamilabd.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 22.05.2023
 */
public class ReentrantLockEx {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(() -> {
            call.telegramCall();
        });
        Thread thread2 = new Thread(() -> {
            call.mobileCall();
        });
        Thread thread3 = new Thread(() -> {
            call.skypeCall();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private final Lock lock = new ReentrantLock();

    void mobileCall() {
        try {
            lock.lock();
            System.out.println("Mobile call started");
            Thread.sleep(2000);
            System.out.println("Mobile call end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        try {
            lock.lock();
            System.out.println("skype call started");
            Thread.sleep(4000);
            System.out.println("skype call end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void telegramCall() {
        if (lock.tryLock()) {
            try {
                System.out.println("telegram call started");
                Thread.sleep(3000);
                System.out.println("telegram call end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Звонок по телеграмму занят другим видом связи.");
        }
    }
}
