package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * HeapSorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/8
 */
public class HeapSorting {
    /**
     * 下沉
     *
     * @param srcArray
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] srcArray, int parentIndex, int length) {
        /**
         * 保存要下沉的父节点
         */
        int temp = srcArray[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        /**
         * childIndex最大值为length-1；
         */
        while (childIndex < length) {
            /**
             * 比较左右子节点，构建最大堆使用较大的值
             */
            if (childIndex + 1 < length && srcArray[childIndex] < srcArray[childIndex + 1]) {
                childIndex++;
            }
            /**
             * 如果父节点大于任意一个子节点，直接退出
             */
            if (temp >= srcArray[childIndex]) {
                break;
            }
            /**
             * 不用直接交换2个值，只需要交换一个就行，
             * 最后将要下沉的父节点放到最终位置上。不用每次都进行赋值。
             */
            srcArray[parentIndex] = srcArray[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;

        }

        /**
         * 将要下沉的父节点，复制到最终位置上
         */
        srcArray[parentIndex] = temp;


    }

    /**
     * 上浮调整
     *
     * @param srcArray
     */
    public static void upAdjust(int[] srcArray, int childIndex) {
        //TODO 感觉有问题
        int parentIndex = (childIndex - 1) / 2;
        int temp = srcArray[childIndex];
        /**
         * 本来要判断parentIndex>=0 但是(parentIndex - 1) / 2 最小值为0
         * 所以可以不判断
         */
        if (temp < srcArray[parentIndex]) {
            return;
        }
        while (childIndex > 0 && temp > srcArray[parentIndex]) {
            srcArray[childIndex] = srcArray[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        srcArray[childIndex] = temp;


    }

    public static void sort(int[] srcArray) {
        /**
         * 1.构建最大堆
         */
//        for (int i = srcArray.length / 2; i >= 0; i--) {
//
//
//            downAdjust(srcArray, i, srcArray.length - 1);
//
//        }

        for (int i = srcArray.length - 1; i > 0; i--) {
            upAdjust(srcArray, i);
        }
        System.out.println(Arrays.toString(srcArray));
        /**
         * 2.删除栈顶元素，替换到二叉堆微末，
         * 调整二叉堆，成最小堆
         */
        for (int i = srcArray.length - 1; i > 0; i--) {

            /**
             * 交换堆顶元素和堆尾元素
             */
            int temp = srcArray[i];
            srcArray[i] = srcArray[0];
            srcArray[0] = temp;
            downAdjust(srcArray, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] srcArray = {3, 1, 10, 9, 4};
        sort(srcArray);
        System.out.println(Arrays.toString(srcArray));
    }
}
