package pro.shamilabd.multithreading.collections;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 24.05.2023
 */
public class ArrayBlockingQueueEx {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    queue.put(++i);
                    System.out.println("Producer dobavil: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        // Consumer
        new Thread(() -> {
            while (true) {
                try {
                    Integer i = queue.take();
                    System.out.println("Consumer zabral: " + i);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void startExample() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
//        queue.add(5); // IllegalStateException: Queue full
        queue.offer(5); // просто не добавит!!!
    }
}
