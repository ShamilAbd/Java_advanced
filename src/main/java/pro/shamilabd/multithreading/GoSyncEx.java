package pro.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 19.05.2023
 */
public class GoSyncEx {
    private static final Object LOCK = new Object(); // единый объект для блокировки нескольких блоков кода.

    public static void main(String[] args) {
        Thread walking = new Thread(new Walking());
        Thread riding = new Thread(new Riding());
        Thread driving = new Thread(new Driving());
        walking.start();
        driving.start();
        riding.start();
    }

    void walking() {
        synchronized (LOCK) {
            System.out.println("Now I'm walking");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish walking");
        }
    }

    void ridingOnBike() {
        synchronized (LOCK) {
            System.out.println("Now I'm riding on my bike");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish ride on bike");
        }
    }

    void drivingCar() {
        synchronized (LOCK) {
            System.out.println("Now I'm drive on car");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finish drive car");
        }
    }
}

class Walking implements Runnable {
    @Override
    public void run() {
        new GoSyncEx().walking();
    }
}

class Riding implements Runnable {
    @Override
    public void run() {
        new GoSyncEx().ridingOnBike();
    }
}

class Driving implements Runnable {
    @Override
    public void run() {
        new GoSyncEx().drivingCar();
    }
}