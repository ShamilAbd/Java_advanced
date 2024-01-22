package pro.shamilabd.multithreading;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 18.05.2023
 */
public class NameAndPriority {
    public static void main(String[] args) {
        Thread thread1 = new SimpleThread();
        Thread thread2 = new SimpleThread();
        System.out.println("Thread1 name: " + thread1.getName()
            + ", priority: " + thread1.getPriority());
        System.out.println("Thread2 name: " + thread2.getName()
                + ", priority: " + thread2.getPriority());
        //Thread1 name: Thread-0, priority: 5
        //Thread2 name: Thread-1, priority: 5

        thread1.setName("MySimpleThread");
        thread1.setPriority(7);
        thread2.setName("Second Thread");
        thread2.setPriority(Thread.MAX_PRIORITY); // 10
        System.out.println("Thread1 name: " + thread1.getName()
                + ", priority: " + thread1.getPriority());
        System.out.println("Thread2 name: " + thread2.getName()
                + ", priority: " + thread2.getPriority());
    }

}


