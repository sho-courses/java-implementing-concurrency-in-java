package io.github.shomeier.module4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleInvokeAll {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);
        try {
            Thread.sleep(100);
            List<Future<Integer>> results = executorService.invokeAll(callables);
            System.out.println("Result 1st Thread: " + results.get(0).get());
            System.out.println("Result 2nd Thread: " + results.get(1).get());
            System.out.println(executorService.invokeAll(callables));
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
