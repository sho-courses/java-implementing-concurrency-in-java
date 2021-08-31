package io.github.shomeier.module3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizeOnReentrantLock {

    public static Lock lock = new ReentrantLock();
    public static int counter = 0;

    public static void incrementCounter() throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            try {
                int current = counter;
                System.out.println("Before: " + counter + " Current thread: " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Thread didn't get the lock and looking for a new task...");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    incrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
