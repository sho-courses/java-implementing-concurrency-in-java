package io.github.shomeier.module2;

public class RunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            System.out.println("Is interrupted: " + Thread.currentThread().isInterrupted());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // interrupt flag is cleared at this point
                System.out.println("Is interrupted: " + Thread.currentThread().isInterrupted());


                // printStackTrace needs some time to be printed (always at the end)
                // e.printStackTrace();
                System.out.println("Interrupted exception: " + e);

                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
