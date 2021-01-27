package com.ac.java8.reduce;

import java.util.Optional;
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


        Optional<String> reduce = Stream.of("1", "3", "4", "5").reduce(ReduceDemo::contact);
        System.out.println(reduce.get());

    }

    public static String contact(String a1, String a2) {
        return a1 + a2;
    }
}
