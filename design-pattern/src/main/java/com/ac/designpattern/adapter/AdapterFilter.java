package com.ac.designpattern.adapter;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Filter
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/14
 */
public class AdapterFilter implements Processor {
    Filter filter;

    public AdapterFilter(Filter filter) {
        this.filter = filter;
    }

    public void doFilter() {
        filter.doFilter(new String[]{"abc", "bc", "dff"});
    }

    public static void main(String[] args) throws IOException {
//        new AdapterFilter(new Filter()).doFilter();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(RandomUtils.nextInt(10, 40));
        }
        List<Integer> nums1 = nums
                .stream()
                .filter(num -> num > 10)
                .sorted((a, b) -> a - b)
                .collect(toList());

        long count = nums
                .stream()
                .filter(num -> num > 10)
                .skip(1)
                .limit(2)
                .count();

        List<String> collect = nums.stream()
                .map(num -> String.valueOf(num))
                .filter(num -> num.contains("1"))
                .collect(toList());
        Stream<Integer> integerStream = nums.stream()
                .map(num -> num + 1);


        Optional<Integer> min = nums.stream()
                .min(Comparator.reverseOrder());
        Integer integer = min.get();

        Stream<Integer> reduce = nums.stream().sorted(Comparator.comparing(Integer::intValue));
        OptionalDouble average = nums.stream().mapToInt(Integer::intValue).average();
//        Integer integer1 = reduce.get();
//
//         nums.stream()
//                .mapToInt(Integer::intValue)
//                .collect(groupingBy(Integer::intValue));
        int sum = IntStream.rangeClosed(1, 10).sum();
        Stream<String> stream = Files.lines(Paths.get("/Users/mac/study/execises/design-pattern/src/main/resources/data.txt"));
//        Stream<Object> objectStream = nums.stream().flatMap(num -> num + 1);
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list
                .stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(toList());

    }

}
