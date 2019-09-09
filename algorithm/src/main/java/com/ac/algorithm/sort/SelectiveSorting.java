package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * SelectiveSorting
 * 正序排列
 * 时间复杂度O(n2)
 * 空间复杂度O(1)
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/6
 */
public class SelectiveSorting {


    public static int[] selectiveSorting(int[] srcArray) {
        int temp = 0;
        int pos = 0;
        for (int i = 0; i < srcArray.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < srcArray.length; j++) {
                /**
                 * 记录每轮最小的数的小标
                 */
                if (srcArray[j] < srcArray[pos]) {
                    pos = j;
                }
            }
            /**
             * 交换最小数和第i数
             */
            temp = srcArray[pos];
            srcArray[pos] = srcArray[i];
            srcArray[i] = temp;

        }
        return srcArray;
    }

    public static void main(String[] args) {
        int[] ints = selectiveSorting(new int[]{3, 1, 6, 9, 4});
        System.out.println(Arrays.toString(ints));
    }
}
