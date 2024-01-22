package pro.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 19.05.2023
 */
public class DataRaceEx {
    public static void main(String[] args) {
        Racer racer = new Racer();
        Thread racer1 = new Thread(racer);
        Thread racer2 = new Thread(racer);
        Thread racer3 = new Thread(racer);
        racer1.start();
        racer2.start();
        racer3.start();
        // 0 1 2 0 4 5 0 7 8 - incrementNotSync
        // 0 1 2 3 4 5 6 7 8 - for incrementSync
    }
}

class Counter {
    public volatile static int count;
}

class Racer implements Runnable {
    private Object lock = new Object();

    public void incrementNotSync() {
        System.out.print(Counter.count + " ");
        Counter.count++;
    }

    // synchronized all method. Неявная синхронизация по this
    // для static синхронизация по классу.
    public synchronized void incrementSync() {
        System.out.print(Counter.count + " ");
        Counter.count++;
    }

    public void incrementSyncThisObject() {
        // not import for sync code
        synchronized (this) { // synchronized only need block
            System.out.print(Counter.count + " ");
            Counter.count++;
        }
        // not import for sync code
    }

    public void incrementSyncOtherObject() {
        // not import for sync code
        synchronized (lock) { // synchronized only need block
            System.out.print(Counter.count + " ");
            Counter.count++;
        }
        // not import for sync code
    }

    public void decrementSyncOtherObject() {
        // not import for sync code
        synchronized (lock) { // synchronized with incrementSyncOtherObject (for example)
            System.out.print(Counter.count + " ");
            Counter.count--;
        }
        // not import for sync code
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
//            incrementNotSync();
            incrementSync();
        }
    }
}