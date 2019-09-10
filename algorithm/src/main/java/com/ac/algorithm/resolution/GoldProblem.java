package com.ac.algorithm.resolution;

/**
 * GoldProblem
 * 金矿问题
 * 假如有w个工人👷和n堆金矿，每堆金矿分别需要分配一定数量的工人去挖，并且只能挖完或者不挖，不能挖一半。
 * 怎么分配才能获得最多金子。
 * 基本思路：
 * 1. 将这个问题不断分解成子问题。
 * 2. 分解结束的条件的剩余金矿为0或者工人人数为0；
 * 3. 将子问题的最优解合成整体的最优解。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class GoldProblem {

    /**
     * @param w 工人人数
     * @param n 金矿堆数
     * @param p 每堆金矿对应所需开采人数
     * @param g 每堆金矿对应金子数
     * @return {@code int} 最多能获得的金子数
     */
    public static int getMaxGold(int w, int n, int[] p, int[] g) {
        /**
         * 工人人数为0或者金矿数为0
         */
        if (n == 0 || w == 0) {

            return 0;
        }
        /**
         * 剩余工人人数小于当前金矿开采所需人数
         */
        if (p[n - 1] > w) {
            return getMaxGold(w, n - 1, p, g);
        }
        /**
         * 剩余工人人数大于等于当前金矿开采所需人数
         */
        return Math.max(getMaxGold(w, n - 1, p, g), getMaxGold(w - p[n - 1], n - 1, p, g) + g[n - 1]);

    }

    public static void main(String[] args) {
        int[] p = new int[]{5, 3, 4, 2};
        int[] g = new int[]{20, 30, 60, 40};
        int maxGold = getMaxGold(10, 4, p, g);
        System.out.println(maxGold);
    }
}
