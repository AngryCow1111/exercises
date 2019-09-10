package com.ac.algorithm.resolution;

/**
 * FindEvenCountNumInArray
 * 假如一个无需数组中，有一个数字出现奇数次，而其他都出现偶数次。
 * 找出这个出现奇数次的数。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class FindEvenCountNumInArray {

    public static int findEvenCountNumInArray(int[] srcArray) {
        int result = srcArray[0];
        for (int i = 1; i < srcArray.length; i++) {
            result = result ^ srcArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int evenCountNumInArray = findEvenCountNumInArray(new int[]{3, 5, 3});
        System.out.println(evenCountNumInArray);
    }
}
