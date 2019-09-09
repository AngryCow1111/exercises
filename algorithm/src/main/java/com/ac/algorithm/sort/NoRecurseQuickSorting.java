package com.ac.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NoRecurseQuickSorting
 * 非递归实现快排
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/8
 */
public class NoRecurseQuickSorting {

    public static void quickSorting(int[] srcArray, int startIndex, int endIndex) {

        Stack<Map<String, Integer>> operationStack = new Stack<>();
        Map<String, Integer> rootPartion = new HashMap<>();
        rootPartion.put("startIndex", startIndex);
        rootPartion.put("endIndex", endIndex);
        operationStack.push(rootPartion);
        /**
         * 执行入栈出栈操作，直到栈为空为止
         */
        while (!operationStack.isEmpty()) {
            Map<String, Integer> topOperation = operationStack.pop();
            int pivotIndex = partion(srcArray, topOperation.get("startIndex"), topOperation.get("endIndex"));
            /**
             * 分别对两部分进行处理，一部分是小于基数部分（默认是基数左边）
             * 另一个部分是大于基数部分
             */
            if (topOperation.get("startIndex") < pivotIndex) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", topOperation.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                operationStack.push(leftParam);
            }

            if (topOperation.get("endIndex") > pivotIndex) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", topOperation.get("endIndex"));
                operationStack.push(rightParam);
            }
        }
    }

    public static int partion(int[] srcArray, int startIndex, int endIndex) {
        /**
         * 选取一个基数，可以随机获得或默认是数组第一个
         */
        int pivot = srcArray[startIndex];
        int mark = startIndex;
        /**
         * 从基数的下一个开始循环，到endIndex结束
         */
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (srcArray[i] < pivot) {
                mark++;
                int temp = srcArray[i];
                srcArray[i] = srcArray[mark];
                srcArray[mark] = temp;
            }
        }

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
