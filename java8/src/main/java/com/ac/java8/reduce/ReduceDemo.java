package com.ac.java8.reduce;

import java.util.stream.Stream;

/**
 * ReduceDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class ReduceDemo {
    public static void main(String[] args) {
        Integer sum = Stream.of(1, 3, 34, 4)
                .reduce(Integer::sum).get();
    }
}
