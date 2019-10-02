package com.ac.test.utils.test;

import java.util.ArrayList;
import java.util.List;

/**
 * ToArrayTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/24
 */
public class ToArrayTest {
    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("aaa");
        urls.add("bbb");
        urls.add("ccc");
        urls.add("ddd");

        urls.toArray(new String[0]);
    }
}
