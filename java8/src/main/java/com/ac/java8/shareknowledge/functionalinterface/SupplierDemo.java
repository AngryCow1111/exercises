package com.ac.java8.shareknowledge.functionalinterface;

import java.util.function.Supplier;

/**
 * SupplierDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class SupplierDemo {

    public static void main(String[] args) {

//        Supplier<Long> supplier1 = supply();
//        System.out.println(supplier1.get());
//        System.out.println(supply2().get());
//        System.out.println(supply3());
        test(SupplierDemo::supply3);
    }

    public static Supplier<Long> supply() {
        return System::currentTimeMillis;
    }

    public static Supplier<String> supply2() {
        return () -> {
            return "hello world";
        };
    }

    public static String supply3() {

        return "hello world";
    }

    public static void test(Supplier<String> stringSupplier) {
        System.out.println(stringSupplier.get());
    }
}
