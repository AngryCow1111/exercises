package com.ac.algorithm.resolution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * LinkedListCloseLoop
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class LinkedListCloseLoop {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);
        resolution1(linkedList);
        resoultion2(linkedList);
        boolean isLoop = false;
        int p1 = 0, p2 = 0;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param linkedList
     */
    private static void resoultion2(LinkedList<Integer> linkedList) {
        Set<Integer> noDuplicate = new HashSet<>();
        boolean isLoop = false;
        for (Integer integer : linkedList) {
            boolean isSuccess = noDuplicate.add(integer);
            if (!isSuccess) {
                isLoop = true;
            }
        }
    }

    /**
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     *
     * @param linkedList
     */
    private static void resolution1(LinkedList<Integer> linkedList) {
        int index = 0;
        boolean isLoop = false;
        for (int i = 0; i < linkedList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (linkedList.get(i) == linkedList.get(j)) {
                    isLoop = true;
                }
            }
        }
    }

}
