package io.github.shomeier.module5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        var syncList = Collections.synchronizedList(list);

        // go ahead and syncList safely with multiple threads
        // be aware though: you cannot modify a synchronizedCollection while iteration over it
        // you will get a ConcurrentModificationException

    }
}
