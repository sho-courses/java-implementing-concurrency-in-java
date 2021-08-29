package io.github.shomeier.module2.interrupt;

public class App {

    public static void main(String[] args) {
        Thread t = new Thread(new RunThread());
        t.start();
        t.interrupt();
    }
}
