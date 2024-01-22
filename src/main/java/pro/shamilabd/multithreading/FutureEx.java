package pro.shamilabd.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class FutureEx {
    private static long value = 1_000_000_000L;
    private static long summa;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(6);
        List<Future<Long>> futuresResults = new ArrayList<>();

        long valueDividedBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividedBy10 * i + 1;
            long to = valueDividedBy10 * (i + 1);
            Summator task = new Summator(from, to);
            Future<Long> futureResult = service.submit(task);
            futuresResults.add(futureResult);
        }
        for (int i = 0; i < futuresResults.size(); i++) {
            summa += futuresResults.get(i).get();
        }
        service.shutdown();
        System.out.println(summa);
    }
}

class Summator implements Callable<Long> {
    private long from;
    private long to;
    private long summa;

    public Summator(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            summa += i;
        }
        System.out.println("From: " + from + ", to: " + to + ", summa: " + summa);
        return summa;
    }
}
