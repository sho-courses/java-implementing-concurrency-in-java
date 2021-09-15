package io.github.shomeier.module5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionProblemsSolution {

    public static void main(String[] args) {
        Map<String, String> stringStringMap = new ConcurrentHashMap<>();
        stringStringMap.put("Maike", "Java");
        stringStringMap.put("Remsey", "C#");

        for (String k : stringStringMap.keySet()) {
            System.out.println(k + " loves coding " + stringStringMap.get(k));
            stringStringMap.remove(k);
        }

    }
}
