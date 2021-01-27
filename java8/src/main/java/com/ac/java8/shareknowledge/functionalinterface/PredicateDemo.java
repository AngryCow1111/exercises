package com.ac.java8.shareknowledge.functionalinterface;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Predicate;

/**
 * PredicateDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class PredicateDemo {
    public static void main(String[] args) {
        FileFilter fileFilter = file -> {
            return StringUtils.lastIndexOf(file.getName(), "txt") != -1;

        };
        boolean accept = fileFilter.accept(new File("111.txt"));
        Predicate<String> test111 = PredicateDemo::predicate1;
        Predicate<String> test222 = PredicateDemo::predicate2;

        boolean test1 = test111.and(test222).test("hell");
        System.out.println(test1);

//        boolean hel = test.test("hello");
//        System.out.println(hel);
    }

    public static boolean predicate1(String message) {

        return message.contains("hello");
    }


    public static boolean predicate2(String message) {

        return message.contains("hello22");
    }
//    private void test1() {
//        Predicate<String> test = new PredicateDemo()::predicate1;
//    }
}
