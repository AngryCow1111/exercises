package com.ac.java8.filter;

import java.util.Arrays;

/**
 * FilterDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class FilterDemo {
    public static void main(String[] args) {
        Arrays.asList(1, 23, 4, 5, 683, 122121, 3311)
                .stream()
                .filter(num -> num > 110)
                .forEach(System.out::println);
    }
}
