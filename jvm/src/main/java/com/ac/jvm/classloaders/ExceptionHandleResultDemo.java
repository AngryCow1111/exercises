package com.ac.jvm.classloaders;

/**
 * ExceptionHandleResultDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-03
 */
public class ExceptionHandleResultDemo {

    static int num = 1;

    public static int increase() {

        try {
            num = 2;
            num = num / 0;
            return num;
        } catch (Exception e) {
            num = 3;
            return num;
        } finally {
            num = 4;
            return num;
        }
    }

    public static void main(String[] args) {
        int increase = increase();

    }
}
