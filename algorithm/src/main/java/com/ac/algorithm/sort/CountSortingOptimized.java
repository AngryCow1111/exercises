package com.ac.algorithm.sort;

import javax.swing.*;
import java.util.Arrays;

/**
 * CountSortingOptimized
 * 统计排序适合数据差值不大的，并且为数据类型为数字。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class CountSortingOptimized {

    public static void countSortingOptimized(int[] srcArray) {
        int max = srcArray[0];
        int min = srcArray[0];

        for (int i = 1; i < srcArray.length; i++) {
            if (srcArray[i] > max) {
                max = srcArray[i];
            }
            if (srcArray[i] < min) {
                min = srcArray[i];
            }
        }

        int difference = max - min;
        int[] countArray = new int[difference + 1];
        for (int i = 0; i < srcArray.length; i++) {
            countArray[srcArray[i] - min]++;
        }
        System.out.println(Arrays.toString(countArray));

        /**
         * 变型统计数组,前一个和当前位置数组数值相加之和为当前数值。
         * 简单来说，就是后者等于前者和当前之和.
         * 第一个不用计算，所以下标从一开始。
         */
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }
        System.out.println(Arrays.toString(countArray));
        /**
         * 排序后的数组,为了保证顺序。在遍历原数组的时候生成排序后数组时，从后开始遍历。
         * 假如有2个95，在生成统计数组时，应该是前面的一个先被统计进去，所以在生成排序后的数组时，
         * 为了保证顺序一致，需要从后往前就行遍历。
         */
        int[] sortedArray = new int[srcArray.length];
        for (int i = srcArray.length - 1; i >= 0; i--) {
            /**
             * 数据在原数组中的位置,因为得到是从一开始的所以对应的下标要减去1。
             */
            int srcIndex = countArray[srcArray[i] - min] - 1;
            sortedArray[srcIndex] = srcArray[i];
            /**
             * 每排序一个数据，就将对应的统计数组的值减去，每个数据对应其在原数组中的位置。
             */
            countArray[srcArray[i] - min]--;
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    public static void main(String[] args) {
        int[] srcArray = new int[]{90, 99, 92, 94, 98};
        countSortingOptimized(srcArray);
        System.out.println(Arrays.toString(srcArray));
    }
}
