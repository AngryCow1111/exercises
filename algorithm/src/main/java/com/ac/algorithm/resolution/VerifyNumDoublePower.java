package com.ac.algorithm.resolution;

/**
 * VerifyNumDoublePower
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class VerifyNumDoublePower {
    public static boolean verfify(int num) {
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        boolean verfify = verfify(16);
        boolean verfify1 = verfify(15);
    }
}
