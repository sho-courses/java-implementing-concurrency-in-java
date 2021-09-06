package io.github.shomeier.module4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CachedPoolExample {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static Future<Double> getRandom(int i) {
        return executorService.submit(() -> {
            var waitMillis = new Random().nextInt(10) * 100;
            Thread.sleep(waitMillis);
            System.out.println(i + " Thread id: " + Thread.currentThread().getId());
            return Math.random();
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            getRandom(i);
        }

        executorService.shutdown();
    }

}
