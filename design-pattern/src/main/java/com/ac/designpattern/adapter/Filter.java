package com.ac.designpattern.adapter;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Filter
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/14
 */
public class Filter {


    public void doFilter(String... type) {

        String[] strings = {"Hello", "World"};
        Stream<String> strings1 = Stream.of(strings);
        Stream<String[]> stream = strings1.map(s -> s.split(""));
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        stringStream.sorted(String::compareTo).collect(Collectors.toList());
        Map<String, List<String>> collect = stringStream.collect(Collectors.groupingBy(s -> s.substring(1)));

        for (String s : collect.keySet()) {
            System.out.println(s);
        }
    }
}
