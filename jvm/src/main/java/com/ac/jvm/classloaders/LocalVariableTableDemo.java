package com.ac.jvm.classloaders;

/**
 * LocalVariableTableDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-03
 */
public class LocalVariableTableDemo {
    public static void main(String[] args) {
        {
            byte[] bytes = new byte[6 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
