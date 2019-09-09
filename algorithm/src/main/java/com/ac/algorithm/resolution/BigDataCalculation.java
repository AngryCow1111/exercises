package com.ac.algorithm.resolution;

/**
 * BigDataCalculation
 * 利用数组进行存储计算，就像
 * 10033122111
 * +23312212111
 * ––––––––––––––
 * 3334334222
 * 但是要注意进位。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class BigDataCalculation {

    public static String calculate(String num1, String num2) {

        /**
         * 创建较大位数的数据的长度+1的数组用于存储计算的数据，
         * 多一位是为了处理进位问题。
         *
         */
        int length = num1.length() > num2.length() ? num1.length() : num2.length();
        int[] num1Array = new int[length + 1];
        /**
         * 从左往右依次存储，各位数据；
         * 个位在前
         */
        for (int i = 0; i < num1.length(); i++) {
            num1Array[i] = num1.charAt(num1.length() - 1 - i) - '0';
        }

        int[] num2Array = new int[length + 1];
        /**
         * 从左往右依次存储，各位数据；
         * 个位在前
         */
        for (int i = 0; i < num2.length(); i++) {
            num2Array[i] = num2.charAt(num2.length() - 1 - i) - '0';
        }
        int[] sumArray = new int[length + 1];
        /**
         * 此处遍历长度应为num1Array.length-1，最后一位为预留位，不需要去遍历计算。
         */
        for (int i = 0; i < num1Array.length - 1; i++) {
            int sum = num1Array[i] + num2Array[i];
            if (sum >= 10) {
                sumArray[i + 1] = 1;
                sumArray[i] = sum - 10;
            } else {
                sumArray[i] = sum;
            }
        }
        boolean isCarried = false;
        StringBuffer sb = new StringBuffer();
        for (int i = sumArray.length - 1; i >= 0; i--) {
            if (!isCarried) {
                isCarried = true;
                if (sumArray[i] == 0) {
                    continue;
                }
            }
            sb.append(sumArray[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String calculate = calculate("1222", "2222");
        System.out.println(calculate);
    }
}
