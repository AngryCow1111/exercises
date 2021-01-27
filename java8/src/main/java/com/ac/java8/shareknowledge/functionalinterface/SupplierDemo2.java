package com.ac.java8.shareknowledge.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * SupplierDemo2
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class SupplierDemo2<T> {

    public static void main(String[] args) {
        List<String> stringList = new SupplierDemo2<List<String>>().getAll(() -> {
            return new ArrayList<String>();
        });
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    public T getAll(Supplier<T> supplier) {
        return supplier.get();
    }
}
