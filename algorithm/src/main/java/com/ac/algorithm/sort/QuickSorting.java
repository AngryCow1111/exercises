package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * QuickSorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/6
 */
public class QuickSorting {

    public static void quickSorting(int[] srcArray, int startIndex, int endIndex) {
        /**
         * 递归结束标志 startIndex>=endIndex
         */
        if (startIndex >= endIndex) {
            return;
        }

        /**
         * 获得pivot 基数下标
         */
        int pivotIndex = partition(srcArray, startIndex, endIndex);
        /**
         * 基数pivot左边
         */
        quickSorting(srcArray, startIndex, pivotIndex - 1);
        /**
         * 基数pivot右边
         */
        quickSorting(srcArray, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] srcArray, int startIndex, int endIndex) {
        int pivot = srcArray[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            /**
             * right右移动
             */
            while (left < right && srcArray[right] > pivot) {
                right--;
            }

            /**
             * left左移
             */
            while (left < right && srcArray[left] <= pivot) {
                left++;
            }

            /**
             * 交换left和right
             */
            if (right > left) {
                int temp = srcArray[left];
                srcArray[left] = srcArray[right];
                srcArray[right] = temp;
            }

        }
        /**
         * 交换pivot和left和right重合的元素
         */
        srcArray[startIndex] = srcArray[left];
        srcArray[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        quickSorting(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
