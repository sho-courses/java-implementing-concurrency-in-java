package io.github.shomeier.module4;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ScheduledPoolExample {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

    public static void main(String[] args) {
        ScheduledFuture<Double> doubleFuture = executorService.schedule(() -> {
            var waitMillis = new Random().nextInt(10) * 100;
            Thread.sleep(waitMillis);
            System.out.println(1 + " Thread id: " + Thread.currentThread().getId());
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS);

        try {
            System.out.println(doubleFuture.get(100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            doubleFuture.cancel(true);
        }

        if (doubleFuture.isCancelled()) {
            System.out.println("Very sorry but future was cancelled");
        }
        if (doubleFuture.isDone()) {
            System.out.println("I'm done");
        }
        executorService.shutdown();
    }

}
