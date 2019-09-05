package com.ac.java8.consumer;

import java.util.function.Consumer;

/**
 * ConsumerDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = (name) -> name = name + "change";
        consumer.accept("张胜男");

        Consumer<String> tConsumer = (name) -> System.out.println(name);
        tConsumer.accept("zhangsan");
    }

}
