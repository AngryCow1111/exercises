package com.ac.algorithm.resolution;

/**
 * DeleteNNumMinOptimized
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class DeleteNNumMinOptimized {

    public static String deleteNNumMinOptimized(String srcNum, int k) {
        int newLength = srcNum.length() - k;
        char[] stack = new char[srcNum.length()];
        int top = 0;
        for (int i = 0; i < srcNum.length(); i++) {
            char c = srcNum.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }

        /**
         * 找到第一个非0的数据
         */

        int offSet = 0;
        while (offSet < newLength && stack[offSet] == '0') {
            offSet++;
        }
        return offSet == newLength ? "0" : new String(stack, offSet, newLength - offSet);

    }

    public static void main(String[] args) {
        String destStr = deleteNNumMinOptimized("123456", 2);
        System.out.println(destStr);
    }
}
