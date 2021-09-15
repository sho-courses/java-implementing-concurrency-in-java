package io.github.shomeier.module5;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionInterfaces {

    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Nadesh", "PHP");

        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.offer("Maria");
    }
}
