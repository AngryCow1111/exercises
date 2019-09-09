package com.ac.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * CountSorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class CountSorting {

    public static int[] countSorting(int[] srcArray) {
        /**
         * 求最大值
         */
        int max = srcArray[0];
        for (int i = 1; i < srcArray.length; i++) {
            if (srcArray[i] > max) {
                max = srcArray[i];
            }
        }
        /**
         * 创建统计数组，size =max
         */
        int[] countArray = new int[max + 1];
        /**
         * 遍历数组，生成统计数组
         */

        for (int i = 0; i < srcArray.length; i++) {
            countArray[srcArray[i]]++;
        }

        /**
         * 遍历统计数组，输出排序结果
         */
        int[] sortedArray = new int[srcArray.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] srcArray = new int[]{1, 11, 3, 47, 89, 9};
        int[] destArray = countSorting(srcArray);
        System.out.println(Arrays.toString(destArray));
    }
}
