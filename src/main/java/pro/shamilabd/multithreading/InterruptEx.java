package pro.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 22.05.2023
 */
public class InterruptEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        InterruptableEx ex = new InterruptableEx();
        ex.start();
        Thread.sleep(200);
        ex.interrupt(); // скорее всего попадем на время сна и получим обработку InterruptedException-а
        ex.join();
        System.out.println("Main is end");
    }
}

class InterruptableEx extends Thread {
    public void run() {
        int sum = 0;
        for (int i = 0; i < 1000000000; i++) {
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println("Досчитали до: " + sum);
                return;
            }

            sum += Math.sqrt(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время сна.");
                System.out.println("Досчитали до: " + sum);
                return;
            }
        }
        System.out.println(sum);
    }
}
