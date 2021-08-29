package io.github.shomeier.module2;

public class App {

    public static void main(String[] args) {
        Thread t = new Thread(new RunThread());
        t.start();
        t.interrupt();
    }
}
