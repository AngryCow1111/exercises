package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * BubbleSortingOptimized
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/6
 */
public class BubbleSortingOptimized {

    public static int[] bubbleSorting(int[] srcArray) {
        /**
         * 初始化有序区域，假设开始时都是无序的。
         * 每轮排序完，会有使得有序区域加1。
         * 开始时排序范围为整个数组。
         * 但是实际有效范围可能大于排序次数。
         */

        boolean hasSorted = true;
        for (int i = 0; i < srcArray.length - 1; i++) {
            /**
             * 内部循环次数会随着排序轮数的增加而减少。
             *
             */
            int sortedBorder = srcArray.length - 1;
            for (int j = 0; j < sortedBorder; j++) {
                int temp = 0;
                if (srcArray[j] > srcArray[j + 1]) {
                    temp = srcArray[j];
                    srcArray[j] = srcArray[j + 1];
                    srcArray[j + 1] = temp;
                    hasSorted = false;
                    sortedBorder = j;
                }
            }
            /**
             * 判断是否已经有序了，已经有序了就直接结束。
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
