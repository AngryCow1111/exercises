package com.ac.algorithm.resolution;

import java.util.Arrays;

/**
 * FindEvenCountNumsInArray
 * 假如一个无需数组中，有2个数字出现奇数次，而其他都出现偶数次。
 * 找出这2个出现奇数次的数。
 * 基本思路：
 * 1.分治
 * 2.异或
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class FindEvenCountNumsInArray {

    public static int[] findEvenCountNumsInArray(int[] srcArray) {
        int[] result = new int[2];
        int xOrResult = srcArray[0];
        for (int i = 1; i < srcArray.length; i++) {
            xOrResult ^= srcArray[i];
        }
        /**
         * 异或结果为0，代表与题意不符
         */
        if (xOrResult == 0) {
            return null;
        }
        /**
         * 从后往前找到第一个为1的数
         */
        int separator = 1;
        while (0 == (xOrResult & separator)) {
            separator <<= 1;
        }
        for (int i = 0; i < srcArray.length; i++) {
            if (0 == (separator & srcArray[i])) {
                result[0] ^= srcArray[i];
            } else {
                result[1] ^= srcArray[i];
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] evenCountNumsInArray = findEvenCountNumsInArray(new int[]{1, 3, 4, 4, 1, 5});
        System.out.println(Arrays.toString(evenCountNumsInArray));
    }
}
