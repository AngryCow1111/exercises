package com.ac.jvm.oom;

/**
 * StringInternTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class StringInternTest {
    public static void main(String[] args) {
        String s1 = new StringBuilder("加油").append("努力").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
