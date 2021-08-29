package io.github.shomeier.module2.join;

public class RunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Current thread id: " + Thread.currentThread().getId() + ", i: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                // printStackTrace needs some time to be printed (always at the end)
                // e.printStackTrace();
//                System.out.println("Interrupted exception: " + e);
            }
        }
    }
}
