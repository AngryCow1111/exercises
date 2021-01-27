package com.ac.java8.shareknowledge.functionalinterface;

import com.ac.java8.stream.PersonPO;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * FunctionDemo1
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class FunctionDemo1 {
    public static void main(String[] args) {
        Function<String, Long> function1 = Long::valueOf;
        Long apply = function1.apply("111");
        Function<String, Long> transfer1 = FunctionDemo1::transfer1;
        transfer1.apply("2222");

        Function<PersonPO, String> transfer2 = FunctionDemo1::transfer2;
        String name = transfer2.apply(new PersonPO(1, "张三"));
        System.out.println(name);
    }

    public static Long transfer1(String numStr) {
        return Long.valueOf(numStr);
    }

    public static String transfer2(PersonPO personPO) {
        return personPO.getName();
    }
}
