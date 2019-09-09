package com.ac.algorithm.resolution;

/**
 * GreatestDivisor
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class GreatestDivisor {
    /**
     * 欧几里得算法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int greateDivisor1(int num1, int num2) {
        int bigger = num1 > num2 ? num1 : num2;
        int smaller = num1 > num2 ? num2 : num1;
        if (bigger % smaller == 0) {
            return smaller;
        }
        return greateDivisor1(smaller, bigger % smaller);
    }

    /**
     * 更相减损法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int greateDivisor2(int num1, int num2) {
        int bigger = num1 > num2 ? num1 : num2;
        int smaller = num1 > num2 ? num2 : num1;
        if (bigger == smaller) {
            return smaller;
        }
        return greateDivisor2(smaller, bigger - smaller);
    }

    /**
     * 位运算加更相减损
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int greateDivisor3(int num1, int num2) {

        if (num1 == num2) {
            return num1;
        }
        if ((num1 & 1) == 0 && (num2 & 1) == 0) {
            return greateDivisor3(num1 >> 1, num2 >> 1) << 1;
        } else if ((num1 & 1) == 0 && (num2 & 1) != 0) {
            return greateDivisor3(num1 >> 1, num2);
        } else if ((num1 & 1) != 0 && (num2 & 1) == 0) {
            return greateDivisor3(num1, num2 >> 1);
        } else {

            int bigger = num1 > num2 ? num1 : num2;
            int smaller = num1 > num2 ? num2 : num1;

            return greateDivisor3(bigger - smaller, smaller);
        }
    }


    public static void main(String[] args) {
        int divisor = greateDivisor3(300, 38);
        System.out.println(divisor);
    }
}
