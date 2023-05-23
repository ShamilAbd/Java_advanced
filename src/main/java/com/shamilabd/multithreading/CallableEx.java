package com.shamilabd.multithreading;

import java.util.concurrent.*;

/**
 * @author Abdullin Shamil Ildusovich
 * @Date 23.05.2023
 */
public class CallableEx {
    public static int factorialResult;

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
//        FactorialCallable factorialCallable = new FactorialCallable(-6); // java.lang.RuntimeException: Не верное число!
        FactorialCallable factorialCallable = new FactorialCallable(6); // работает только с ExecutorService
        Future<Integer> future = es.submit(factorialCallable);
        try {
            System.out.println(future.isDone());
            System.out.println("Хотим получить результат");
            factorialResult = future.get(); // лочим поток до получения результата
            System.out.println(future.isDone());
            System.out.println("Получили результат");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            es.shutdown();
        }
        System.out.println(factorialResult);
    }

}

class RunnableVersionEx { // old version
    public static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        es.execute(factorial);
        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);
    }

}

class Factorial implements Runnable {
    private int factorialNum;

    public Factorial(int factorial) {
        this.factorialNum = factorial;
    }

    @Override
    public void run() {
        if (factorialNum <= 0) {
            System.out.println("Не верное число!");
        }

        int factorialResult = 1;
        for (int i = 1; i <= factorialNum; i++) {
            factorialResult *= i;
        }

        RunnableVersionEx.factorialResult = factorialResult;
    }
}

class FactorialCallable implements Callable<Integer> {
    private int factorialNum;

    public FactorialCallable(int factorial) {
        this.factorialNum = factorial;
    }

    @Override
    public Integer call() throws Exception {
        if (factorialNum <= 0) {
            throw new RuntimeException("Не верное число!");
        }

        int factorialResult = 1;
        for (int i = 1; i <= factorialNum; i++) {
            factorialResult *= i;
            Thread.sleep(1000);
        }

        return factorialResult;
    }
}