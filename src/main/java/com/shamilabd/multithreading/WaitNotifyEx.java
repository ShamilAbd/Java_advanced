package com.shamilabd.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 19.05.2023
 */
public class WaitNotifyEx {
    public static final int MAX_BREAD_IN_SHOP = 7;

    public static void main(String[] args) {
        BakeryShop bakeryShop = new BakeryShop(MAX_BREAD_IN_SHOP);
        Thread buyers1 = new Thread(new Buyers(bakeryShop));
        Thread buyers2 = new Thread(new Buyers(bakeryShop));
        Thread buyers3 = new Thread(new Buyers(bakeryShop));
        BakeryFactory bakeryFactory1 = new BakeryFactory(bakeryShop);
        BakeryFactory bakeryFactory2 = new BakeryFactory(bakeryShop);
        bakeryFactory1.setName("1");
        bakeryFactory2.setName("2");
        bakeryFactory1.start();
        bakeryFactory2.start();
        buyers1.setName("1");
        buyers2.setName("2");
        buyers3.setName("3");
        buyers1.start();
        buyers2.start();
        buyers3.start();
    }

    public static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BakeryShop  {
    public final int maxBreadCount;
    private int breadsInShop;

    public BakeryShop(int maxBreadInShop) {
        maxBreadCount = maxBreadInShop;
    }

    public synchronized boolean isNeedMoreBread() {
        if (breadsInShop < maxBreadCount) {
            return true;
        }
        return false;
    }

    public synchronized void addBread(int breads) {
        while (breadsInShop >= maxBreadCount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadsInShop += breads;
        System.out.println("Shop: add bread, now: " + breadsInShop);
        notify();
    }

    public synchronized int getBreadsInShop() {
        return breadsInShop;
    }

    public synchronized void sellBread() {
        while (breadsInShop < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadsInShop--;
        System.out.println("Shop: sold bread, now: " + breadsInShop);
        notify();
    }
}

class BakeryFactory extends Thread {
    Random random = new Random();
    private BakeryShop bakeryShop;

    public BakeryFactory(BakeryShop bakeryShop) {
        this.bakeryShop = bakeryShop;
    }

    @Override
    public void run() {
        cookBreadAndPutInShop();
    }

    public void cookBreadAndPutInShop() {
        while (true) {
            cookBread();
        }
    }

    public void cookBread() {
//        System.out.println("Factory" + Thread.currentThread().getName() + ": start cooking bread");
        WaitNotifyEx.sleep(random.nextInt(4) * 1000);
        bakeryShop.addBread(1);
//        System.out.println("Factory" + Thread.currentThread().getName() + ": end cooking bread");
    }
}

class Buyers implements Runnable {
    Random random = new Random();
    private BakeryShop bakeryShop;

    public Buyers(BakeryShop bakeryShop) {
        this.bakeryShop = bakeryShop;
    }

    @Override
    public void run() {
        goToShop();
    }

    public synchronized void goToShop() {
        while (true) {
           buyBread();
        }
    }

    public void buyBread() {
//        System.out.println("Buyer " + Thread.currentThread().getName() + ": start buy bread");
        WaitNotifyEx.sleep(random.nextInt(5) * 1000);
        bakeryShop.sellBread();
//        System.out.println("Buyer " + Thread.currentThread().getName() + ": end buy bread");
    }
}