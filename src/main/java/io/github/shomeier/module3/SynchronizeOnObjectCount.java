package io.github.shomeier.module3;

public class SynchronizeOnObjectCount {

    public static final Object lock = new Object();
    public static int counter = 0;

    public synchronized static void incrementCounter() {
        synchronized (lock) {
            int current = counter;
            System.out.println("Before: " + counter + " Current thread: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(SynchronizeOnObjectCount::incrementCounter);
            t.start();
        }
    }
}
