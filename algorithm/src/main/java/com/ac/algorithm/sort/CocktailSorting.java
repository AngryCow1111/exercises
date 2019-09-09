package com.ac.algorithm.sort;

import java.util.Arrays;

/**
 * CocktailSorting
 * 鸡尾酒排序
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/6
 */
public class CocktailSorting {
    /**
     * 总共循环srcArray.length / 2次
     * 奇数轮从左往右
     * 偶数轮从右往左
     *
     * @param srcArray
     * @return
     */
    public static int[] cocktailSorting(int[] srcArray) {

        int temp = 0;
        for (int i = 0; i < srcArray.length / 2; i++) {
            boolean hasSorted = true;
            int sortedBorder = srcArray.length - 1;
            for (int j = i; j < sortedBorder; j++) {
                if (srcArray[j] > srcArray[j + 1]) {
                    temp = srcArray[j];
                    srcArray[j] = srcArray[j + 1];
                    srcArray[j + 1] = temp;
                    hasSorted = false;
                    sortedBorder = j + 1;
                }

            }

            if (hasSorted) {
                break;
            }
            hasSorted = true;
            sortedBorder = srcArray.length - 1;
            for (int j = srcArray.length - 1 - i; j >= sortedBorder; j--) {
                if (srcArray[j - 1] > srcArray[j]) {
                    temp = srcArray[j];
                    srcArray[j] = srcArray[j - 1];
                    srcArray[j - 1] = temp;
                    sortedBorder = j - 1;
                    hasSorted = false;
                }
            }

            if (hasSorted) {
                break;
            }

        }
        return srcArray;
    }

    public static void main(String[] args) {
        int[] ints = cocktailSorting(new int[]{3, 1, 6, 9, 4});
        System.out.println(Arrays.toString(ints));
    }
}
