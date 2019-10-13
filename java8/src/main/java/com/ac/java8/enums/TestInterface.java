package com.ac.java8.enums;

/**
 * TestInterface
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/7
 */
public interface TestInterface {
    static int num1 = 0;

    static void println() {
        System.out.println(111);
    }

    public static void main(String[] args) {
        println();
    }
}
