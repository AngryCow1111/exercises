package com.ac.java8.newcharacter;

/**
 * FunctionalInterfaceDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public interface FunctionalInterfaceDemo {

    default void defaultMethod() {
        System.out.println("super defaultMethod");
    }
}
