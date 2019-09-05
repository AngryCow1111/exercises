package com.ac.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * ConstantPoolOomTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class ConstantPoolOomTest {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        int i = 0;
        while (true) {
            lists.add(i + "");
            i++;
        }

    }
}
