package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * QuickSortingForSingleCircle
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/8
 */
public class QuickSortingForSingleCircle {

    public static void quickSorting(int[] srcArray, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }
        int pivoitIndex = partion(srcArray, startIndex, endIndex);
        quickSorting(srcArray, startIndex, pivoitIndex - 1);
        quickSorting(srcArray, pivoitIndex + 1, endIndex);

    }

    private static int partion(int[] srcArray, int startIndex, int endIndex) {
        int pivot = srcArray[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            /**
             * 如果当前遍历到的数大于pivot继续遍历；
             * 否则mark++，并交换srcArray[mark]和pivot；
             */
            if (srcArray[i] < pivot) {
                mark++;
                int temp = srcArray[mark];
                srcArray[mark] = srcArray[i];
                srcArray[i] = temp;
            }
        }
        /**
         *每轮结束交换pivot和mark对应的数据
         */
        srcArray[startIndex] = srcArray[mark];
        srcArray[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSorting(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
