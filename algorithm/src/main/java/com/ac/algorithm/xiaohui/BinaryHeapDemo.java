package com.ac.algorithm.xiaohui;

import java.util.Arrays;

/**
 * BinaryHeapDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/4
 */
public class BinaryHeapDemo {
    /**
     * 上浮二叉堆节点，用于插入节点
     * array 已经是一个二叉堆
     *
     * @param array
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;

        /**
         * 保存要上移子节点
         */
        int temp = array[childIndex];

        /**
         * 上移子节点，条件是父节点大于当前子节点
         * 并且子节点要大于0;
         *
         */
        while (childIndex > 0 && temp < array[parentIndex]) {
            /**
             *交换父节点的值
             */
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            /**
             * 寻找上一个父节点
             */
            parentIndex = (parentIndex - 1) / 2;
        }
        /**
         * 确定最终子节点的位置后，赋值
         */
        array[childIndex] = temp;

    }

    /**
     * 下移父节点
     *
     * @param array       已经是一个二叉堆
     * @param parentIndex 父节点下标
     * @param length      二叉堆有效长度
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        /**
         * 保存要下移的父节点
         */
        int temp = array[parentIndex];

        /**
         * 获取最近的子节点下标(左子节点)
         */
        int childIndex = parentIndex << 1 + 1;
        /**
         * 开始下移条件是子节点的下标要小于二叉堆有效长度
         */

        while (childIndex < length) {
            /**
             * 比较左右子节点的大小，哪个小就跟哪个交换
             */
            if (childIndex + 1 < length && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            /**
             * 比较左右子节点中较小的一个和父节点，如果父节点较小，则直接结束；
             * 否则，交换子父节点；
             */
            if (array[parentIndex] < array[childIndex]) {
                break;
            }
            /**
             * 开始交换子父节点
             */
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            /**
             * 找到下一个最近的子节点
             */
            childIndex = childIndex << 2 + 1;

        }
        array[parentIndex] = temp;

    }

    /**
     * 构建二叉堆
     *
     * @param array 随意无序的数组
     */
    public static void buildBinaryHeap(int[] array) {

        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 6, 5, 7, 8, 0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{10, 3, 6, 5, 8, 9};
        buildBinaryHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
