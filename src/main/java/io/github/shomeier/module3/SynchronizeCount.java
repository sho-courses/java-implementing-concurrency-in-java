package io.github.shomeier.module3;

public class SynchronizeCount {

    public static int counter = 0;

    public synchronized static void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + counter + " Current thread: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After: " + counter + " Current thread: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(SynchronizeCount::incrementCounter);
            t.start();
        }
    }
}
