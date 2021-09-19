package io.github.shomeier.module5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicExamples {

    private static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        IntStream.range(0, 10).forEach(i -> executorService.submit(() -> System.out.println(ai.incrementAndGet())));

        executorService.shutdown();
    }

}
