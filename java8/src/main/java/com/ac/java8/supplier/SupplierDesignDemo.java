package com.ac.java8.supplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * SupplierDesignDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class SupplierDesignDemo {

    public static void main(String[] args) {
        Consumer<Supplier<String>> echo = SupplierDesignDemo::echo;
        echo.accept(() -> "message");
    }

    public static void echo(Supplier<String> message) {
        System.out.println(message.get());

    }
}
