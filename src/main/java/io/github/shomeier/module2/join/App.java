package io.github.shomeier.module2.join;

public class App {

    public static void main(String[] args) {
        Thread t = new Thread(new RunThread());
        t.start();

        try {
            t.join(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(new RunThread());
        t2.start();
    }
}
