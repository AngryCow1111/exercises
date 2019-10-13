package com.ac.java8.arrayparalle;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ArrayParalleDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class ArrayParalleDemo {
    public static void main(String[] args) {
        int[] srcArray = new int[200];
        Arrays.parallelSetAll(srcArray,
                index -> ThreadLocalRandom.current().nextInt(1000000));

        Arrays.stream(srcArray)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("------------------------------------");
        Arrays.stream(srcArray)
                .limit(10)
                .forEach(System.out::println);

    }
}
