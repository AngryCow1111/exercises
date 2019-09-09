package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * BunbleSorting
 * 时间复杂度O(n2)
 * 空间复杂度O(1)
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/6
 */
public class BubbleSorting {
    /**
     * ordering sort
     *
     * @param srcArray
     * @return
     */
    public static int[] bubbleSorting(int[] srcArray) {
        int temp;
        boolean hasSorted = true;
        int sortedBorder = 0;
        for (int i = 0; i < srcArray.length - 1; i++) {
            for (int j = i + 1; j < srcArray.length; j++) {
                /**
                 * 正序排列
                 */
                if (srcArray[i] > srcArray[j]) {
                    temp = srcArray[i];
                    srcArray[i] = srcArray[j];
                    srcArray[j] = temp;
                    hasSorted = false;
                    sortedBorder = j;
                }

            }
            /**
             * 判断是否已经有序
             */
            if (hasSorted) {
                break;
            }

        }
        return srcArray;
    }

    public static void main(String[] args) {
        int[] ints = bubbleSorting(new int[]{3, 1, 6, 9, 4});
        System.out.println(Arrays.toString(ints));
    }
}
