package com.ac.java8.functional;

import java.util.function.Supplier;

/**
 * SupplierDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class SupplierDemo {


    public static void main(String[] args) {
        Supplier<Long> aLong = getLong();
        aLong.get();
    }

    public static Supplier<Long> getLong() {
        return System::currentTimeMillis;
    }
}
