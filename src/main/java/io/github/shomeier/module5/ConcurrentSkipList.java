package io.github.shomeier.module5;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipList {

    public static void main(String[] args) {
        Set<String> set = new ConcurrentSkipListSet<>();
        set.add("Tim");
        set.add("Pascal");
        set.add("Elias");

        for (String string : set) {
            System.out.println(string);
        }

        // ConcurrentSkipListSet is sorted like TreeSet (SortedSet)
        Map<String, String> map = new ConcurrentSkipListMap<>();
        map.put("Guitar", "Jesse");
        map.put("Bass", "Job");
        map.put("Piano", "Sietske");

        // ConcurrentSkipListMap is sorted by key like TreeMap (SortedMap)
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
