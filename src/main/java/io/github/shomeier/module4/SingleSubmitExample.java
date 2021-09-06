package io.github.shomeier.module4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleSubmitExample {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static Future<Double> getRandom(int i) {
        return executorService.submit(() -> {
            System.out.println(i);
            Thread.sleep(1000);
            return Math.random();
        });
    }

    public static void main(String[] args) {
        Future<Double> doubleFuture = getRandom(1);
        getRandom(2);
        getRandom(3);
        getRandom(4);
        while (!doubleFuture.isDone()) {
            if (doubleFuture.isCancelled()) {
                System.out.println("Your future was cancelled, we're sry!");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(doubleFuture.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
