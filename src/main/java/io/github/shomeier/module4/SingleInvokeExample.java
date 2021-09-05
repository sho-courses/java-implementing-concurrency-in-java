package io.github.shomeier.module4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleInvokeExample {

    public static void main(String[] args) {

        // ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);
        try {
            Thread.sleep(100);
            // in SingleThreadExecutor we have only a single thread so Thread id will always be the same
            System.out.println(executorService.invokeAny(callables));
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
