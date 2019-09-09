package com.ac.algorithm.sort;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * BucketSorting
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class BucketSorting {
    /**
     * 基本思路是分治，为原始数组建立若干个桶，
     * 每个桶都有一个区间范围，遍历原始数组，将数据放入对应的桶中。
     * 然后对每个通进行排序，最后生成最终的有序数组。
     */
    public static void bucketSorting(double[] srcArray) {
        double max = srcArray[0];
        double min = srcArray[0];
        for (int i = 0; i < srcArray.length; i++) {
            if (max < srcArray[i]) {
                max = srcArray[i];
            }
            if (min > srcArray[i]) {
                min = srcArray[i];
            }
        }
        /**
         * 桶的数量默认设置为数组长度相同
         */
        int bucketNum = srcArray.length;
        /**
         * 每个桶的区间范围为(max-min)/bucketNum
         */
        double duration = (max - min);
        List<LinkedList<Double>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new LinkedList<>());
        }

        /**
         * 遍历原数组将数据放入每个桶中
         */
        for (int i = 0; i < srcArray.length; i++) {
            int bucketIndex = (int) ((srcArray[i] - min) * (bucketNum - 1) / duration);
            buckets.get(bucketIndex).add(srcArray[i]);
        }
        /**
         * 对每个桶数据进行排序
         */

        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));

        }

        double[] sortedArray = new double[srcArray.length];
        int index = 0;
        for (LinkedList<Double> bucket : buckets) {
            while (!CollectionUtils.isEmpty(bucket)) {
                sortedArray[index] = bucket.removeFirst();
                index++;
            }
        }
        System.out.println(Arrays.toString(sortedArray));
    }

    public static void main(String[] args) {
        double[] srcArray = new double[]{1.2, 3.4, 1.1, 5.9};
        bucketSorting(srcArray);
    }
}
