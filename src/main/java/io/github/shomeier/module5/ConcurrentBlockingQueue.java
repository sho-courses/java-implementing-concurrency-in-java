package io.github.shomeier.module5;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ConcurrentBlockingQueue {

    public static void main(String[] args) {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.offer("Maria");
        queue.offer("Saleh");
        queue.offer("Tom");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.contains("Saleh"));

        System.out.println(queue);

        // special for concurrent queues

        try {
            queue.offer("Jim", 200, TimeUnit.MILLISECONDS);
            queue.poll(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }
}
