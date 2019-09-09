package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * InsertiveSorting
 * a simple sample for insertive sorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-29
 */
public class InsertiveSorting {

    /**
     * @param srcData source data of list
     * @return a list of {@code Integer} for specified order
     * default ASC if no specified,otherwise for specified order {@code ASC} or {@code DESC}
     */
    public static int[] insertiveSorting(int[] srcData) {

//TODO
        for (int i = 1; i < srcData.length - 1; i++) {
            int temp = srcData[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的数向后移动一步
                if (srcData[j] > temp) {
                    srcData[j + 1] = srcData[j];//记录j的值也就是temp要插入的位置
                } else {
                    break;
                }
            }
            srcData[j + 1] = temp;

        }
        return srcData;

    }

    public static void main(String[] args) {
        int[] ints = insertiveSorting(new int[]{3, 1, 6, 9, 4});
        System.out.println(Arrays.toString(ints));
    }
}
