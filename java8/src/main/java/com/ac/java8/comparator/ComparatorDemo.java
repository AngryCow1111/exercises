package com.ac.java8.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ComparatorDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class ComparatorDemo {
    public static void main(String[] args) {

        Arrays.asList(1, 23, 5, 9, 66, 55, 61, 92)
                .stream().skip(1)
                .sorted(Comparator.reverseOrder())
                .parallel()
                .forEach((nums) -> System.out.println(Thread.currentThread().getName()));
    }
}
