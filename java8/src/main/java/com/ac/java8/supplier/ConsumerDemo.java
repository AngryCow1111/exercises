package com.ac.java8.supplier;

import java.util.function.Consumer;

/**
 * ConsumerDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer1 = ConsumerDemo::echo;
        Consumer<String> stringConsumer = (String message) -> {
            System.out.println(message);
        };
        stringConsumer.accept("111");
        consumer.andThen(consumer1)
                .andThen(consumer)
                .accept("hello word");

    }

    public static void echo(String messsage) {

        System.out.println("echo: " + messsage);
    }
}
