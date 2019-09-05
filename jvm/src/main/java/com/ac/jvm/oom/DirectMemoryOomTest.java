package com.ac.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * DirectMemoryOomTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class DirectMemoryOomTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field[] declaredFields = Unsafe.class.getDeclaredFields();
        Field declaredField = declaredFields[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
