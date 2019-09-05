package com.ac.java8.supplier;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * SupplierDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "111";
    }

    public static Supplier<String> getName() {
        Supplier<String> supplier = () -> "111";
        return supplier;
    }
}
