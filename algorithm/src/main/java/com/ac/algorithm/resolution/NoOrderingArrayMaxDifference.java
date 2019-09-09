package com.ac.algorithm.resolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * NoOrderingArrayMaxDifference
 * 无序数组求最大相邻差值
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class NoOrderingArrayMaxDifference {

    /**
     * 使用计数排序
     *
     * @param srcArrray
     * @return
     */
    public static int resoluetion1(int[] srcArrray) {
        int max = srcArrray[0];
        int min = srcArrray[0];

        for (int i = 0; i < srcArrray.length; i++) {
            if (max < srcArrray[i]) {
                max = srcArrray[i];
            }

            if (min > srcArrray[i]) {
                min = srcArrray[i];
            }
        }

        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < srcArrray[i]; i++) {
            countArray[srcArrray[i] - min]++;
        }
        int difference = 0;
        int maxDifferece = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == 0) {
                difference++;
                continue;
            }
            if (maxDifferece < difference) {
                maxDifferece = difference;
            }
            difference = 0;
        }

        return maxDifferece;
    }

    /**
     * 使用桶排序
     *
     * @param srcArrray
     * @return
     */
    public static int resoluetion2(int[] srcArrray) {
        int max = srcArrray[0];
        int min = srcArrray[0];

        for (int i = 0; i < srcArrray.length; i++) {
            if (max < srcArrray[i]) {
                max = srcArrray[i];
            }

            if (min > srcArrray[i]) {
                min = srcArrray[i];
            }
        }
        Bucket[] buckets = new Bucket[srcArrray.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        /**
         * 循环确定每个桶的最大、最小值
         */
        for (int i = 0; i < srcArrray.length; i++) {
            int bucketIndex = (srcArrray[i] - min) * (srcArrray.length - 1) / (max - min);
            if (buckets[bucketIndex].min == null || buckets[bucketIndex].min > srcArrray[i]) {
                buckets[bucketIndex].min = srcArrray[i];
            }

            if (buckets[bucketIndex].max == null || buckets[bucketIndex].max < srcArrray[i]) {
                buckets[bucketIndex].max = srcArrray[i];
            }
        }

        /**
         * 循环每个桶获得最大相邻差
         */
        int maxDifference = 0;
        int leftMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDifference) {
                maxDifference = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDifference;
    }

    public static void main(String[] args) {
        int[] srcArray = new int[]{1,200000,1000,2};
        int difference = resoluetion2(srcArray);
        System.out.println(difference);
    }
}
