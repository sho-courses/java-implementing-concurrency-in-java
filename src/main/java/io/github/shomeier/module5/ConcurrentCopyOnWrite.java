package io.github.shomeier.module5;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCopyOnWrite {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Squirrel");
        list.add("Mouse");
        list.add("Hamster");

        // CopyOnWrite creates a copy of the list when writing to it
        // so the list we are looping over is different from the one we are writing to!
        // that is why we do not iterate indefinitely here
        for (String s : list) {
            System.out.println(s);
            list.add(s);
        }

        System.out.println(list);


        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Horse");

        // set can only contain unique elements
        for (String s : set) {
            System.out.println(s);
            set.add(s);
        }

        System.out.println(set);
    }
}
