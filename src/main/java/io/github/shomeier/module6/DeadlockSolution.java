package io.github.shomeier.module6;

public class DeadlockSolution {

    public static void run() {
        final String resource1 = "stuck";
        final String resource2 = "forever";

        Thread thread1 = new Thread(() -> {

            synchronized (resource1) {
                System.out.println("Thread1 has a lock on resource1");

                // make sure it's not too fast and avoids deadlock
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread1 has a lock on resource2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            synchronized (resource1) {
                System.out.println("Thread2 has a lock on resource1");

                // make sure it's not too fast and avoids deadlock
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread2 has a lock on resource2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        run();
    }

}
