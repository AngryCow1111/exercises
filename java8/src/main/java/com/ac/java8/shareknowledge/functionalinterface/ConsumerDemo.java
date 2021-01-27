package com.ac.java8.shareknowledge.functionalinterface;

import java.util.function.Consumer;

/**
 * ConsumerDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class ConsumerDemo {
    public static void main(String[] args) {
//        consumer1("hehe");

        Consumer<String> consumer1 = ConsumerDemo::consumer1;
//        consumer1.accept("hehe¬");
        Consumer consumer2 = (t) -> {
            System.out.println(t);
        };
//        consumer2.accept("hehe");

        consumer1.andThen(consumer2).accept("hahahaha");

    }

    public static void consumer1(String message) {
        System.out.println(message + "221111");
    }
}
