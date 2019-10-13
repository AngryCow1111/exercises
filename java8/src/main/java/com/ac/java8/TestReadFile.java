package com.ac.java8;

import java.io.InputStream;

/**
 * TestReadFile
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-18
 */
public class TestReadFile {

    public static void main(String[] args) {
//        InputStream resourceAsStream = TestReadFile.class.getResourceAsStream("data.txt");
//        Integer integer = Integer.valueOf(1991);
        Integer integer = new Integer(1222);
        doAccumate(integer);
        System.out.println(integer);
        String str = "world";
        doAccumate(str);
        System.out.println(str);
    }

    private static void doAccumate(Integer integer) {
        integer++;
    }

    private static void doAccumate(String s) {
        s += "hello";
    }
}
