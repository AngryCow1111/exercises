package com.ac.java8.list;

import java.util.ArrayList;

/**
 * ListDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-12
 */
public class ListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list1.add(i);
        }


        for (Integer element : list1) {
            if (Integer.valueOf(2).equals(element)) {
                list1.remove(element);
            }
        }

        System.out.println(list1);
    }
}
