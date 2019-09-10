package com.ac.algorithm.resolution;

/**
 * FindNumInArray
 * 找出连续范围内数据组中不存在的一个数
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class FindNoexsitentNumInArray {

    public static int getFindNonexsitentNum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (start + end) * end / 2 - sum;
    }

    public static void main(String[] args) {
        int findNonexsitentNum = getFindNonexsitentNum(new int[]{1, 3, 4, 5}, 1, 5);
        System.out.println(findNonexsitentNum);
    }
}
