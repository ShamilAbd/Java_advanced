package pro.shamilabd.multithreading.syncronizators;

import java.util.concurrent.CountDownLatch;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class CountDownLatchEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Настало утро.");
        Shop shop = new Shop();
        Customer customer1 = new Customer("Vasya", shop);
        Customer customer2 = new Customer("Petya", shop);
        Customer customer3 = new Customer("Dima", shop);
        Customer customer4 = new Customer("Lena", shop);
        shop.preparingForShopping();
        System.out.println("Main is end");
    }
}

class Shop {
    private CountDownLatch counter = new CountDownLatch(4);

    public void preparingForShopping() throws InterruptedException {
        System.out.println("Пора собираться на работу - " + counter.getCount());
        counter.countDown();
        Thread.sleep(2000);
        System.out.println("Продавцы пришли на работу - " + counter.getCount());
        counter.countDown();
        Thread.sleep(2000);
        System.out.println("Все товары разложили по полкам - " + counter.getCount());
        counter.countDown();
        Thread.sleep(2000);
        System.out.println("Двери открыты - " + counter.getCount());
        Thread.sleep(2000);
        System.out.println("Вперед!!!");
        counter.countDown();
    }

    public void shopping(String name) {
        try {
            System.out.println(name + " хочет начать покупать");
            counter.await(); // ждем отсечки
            System.out.println(name + " купил все что хотел");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Customer extends Thread {
    private String name;
    private Shop shop;

    public Customer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
        this.start();
    }

    @Override
    public void run() {
        shop.shopping(name);
    }
}