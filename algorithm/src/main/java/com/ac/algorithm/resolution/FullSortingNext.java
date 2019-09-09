package com.ac.algorithm.resolution;

import java.util.Arrays;

/**
 * FullSortingNext
 * 基本思路：
 * 给定一个正整数，比如123456，要找到一个仅大于它的一个数，
 * 尽量保证高位不动，从低位开始移动。
 * 比如先交换5和6。变成12365。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class FullSortingNext {

    public static int[] getFullSortingNext(int[] srcArray) {
        int transferPointIndex = findTransferPoint(srcArray);

        if (0 == transferPointIndex) {
            return null;
        }

        /**
         * 交换transferPointIndex
         */
        int[] copyArray = Arrays.copyOf(srcArray, srcArray.length);
        copyArray = exchageHead(transferPointIndex, copyArray);
        /**
         * 将逆序区转化为正序
         */
        copyArray = reverse(transferPointIndex, copyArray);
        return copyArray;
    }

    private static int[] reverse(int transferPointIndex, int[] copyArray) {
        for (int i = transferPointIndex, j = copyArray.length - 1; i < j; i++, j--) {
            if (copyArray[i] > copyArray[j]) {
                int temp = copyArray[i];
                copyArray[i] = copyArray[j];
                copyArray[j] = temp;
            }
        }

        return copyArray;
    }

    /**
     * 交换无序区的头
     *
     * @param transferPointIndex
     * @param copyArray
     */
    private static int[] exchageHead(int transferPointIndex, int[] copyArray) {
        int chaneIndex = transferPointIndex - 1;
        int temp = copyArray[chaneIndex];
        for (int i = copyArray.length - 1; i > 0; i--) {
            if (temp < copyArray[i]) {
                copyArray[chaneIndex] = copyArray[i];
                copyArray[i] = temp;
                break;
            }
        }
        return copyArray;
    }

    private static int findTransferPoint(int[] srcArray) {

        for (int i = srcArray.length - 1; i > 0; i--) {
            if (srcArray[i] > srcArray[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] srcArray = new int[]{1, 2, 5, 4, 3};
        int[] fullSortingNext = getFullSortingNext(srcArray);
        System.out.println(Arrays.toString(fullSortingNext));
    }
}
