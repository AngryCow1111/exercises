package com.ac.algorithm.resolution;

/**
 * GoldProblemOptimized
 * 金矿问题优化
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class GoldProblemOptimized {

    /**
     * @param w 工人人数
     * @param n 金矿堆数
     * @param p 每堆金矿对应所需开采人数
     * @param g 每堆金矿对应金子数
     * @return {@code int} 最多能获得的金子数
     */
    public static int getMaxGold(int w, int n, int[] p, int[] g) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                /**
                 * 当前工人人数小于当前金矿开采所需人数
                 */
                if (p[i - 1] > j) {
                    table[i][j] = table[i - 1][j];
                    continue;
                }

                table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - p[i - 1]] + g[i - 1]);

            }
        }
        return table[n][w];
    }

    public static int getMaxGold1(int w, int n, int[] p, int[] g) {
        int[] table = new int[w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= 1; j--) {
                /**
                 * 当前工人人数小于当前金矿开采所需人数,不用变。还是用少一层的数据。
                 */
                if (p[i - 1] <= j) {
                    table[j] = Math.max(table[j], table[j - p[i - 1]] + g[i - 1]);
                }


            }
        }
        return table[w];
    }

    public static void main(String[] args) {
        int[] p = new int[]{5, 3, 4, 2};
        int[] g = new int[]{20, 30, 60, 40};
        int maxGold = getMaxGold1(10, 4, p, g);
        System.out.println(maxGold);
    }
}
