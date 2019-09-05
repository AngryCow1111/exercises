package com.ac.java8.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FlatMapDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class FlatMapDemo {
    public static void main(String[] args) {
//        String[] strings = {"Hello", "World"};
//        Arrays.asList(strings)
//                .stream()
//                .map(s -> s.split(""))
//                .flatMap(s -> Arrays.asList(s).stream())
//                .collect(Collectors.toList());


//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            list.add(i);
//        }
//
//        long beginTime = System.currentTimeMillis();
//
//        list.stream()
//                .parallel()
//                .forEach(System.out::println);
//
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("cost time:  " + (endTime - beginTime));


        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}