package com.ac.java8.Map;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * HashMapDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-12
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map map = new IdentityHashMap<>();
        map.put(1, "Hello");
        map.putIfAbsent(1, "World");
        print(map.get(1));
        print(map.size());

        map.put(1024, "A");
        map.putIfAbsent(1024, "B");
        print(map.get(1024));
        print(map.size());

    }

    private static void print(Object object) {
        System.out.print(object + " ");
    }
}
