package com.ac.algorithm.resolution;

/**
 * DeleteNNumMin
 * 给定一个正整数，删除k个数后，使得新数最小。
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/9
 */
public class DeleteNNumMin {

    public static String deleteNNumMin(String srcNum, int k) {
        int count = 0;
        String newNum = srcNum;
        for (int i = 0; i < k; i++) {
            boolean isDeleted = false;
            for (int j = 1; j < newNum.length() - 1; j++) {
                if (srcNum.charAt(i) > srcNum.charAt(i + 1)) {
                    newNum = newNum.substring(0, i) + newNum.substring(i + 1);
                    isDeleted = true;
                }
            }
            if (!isDeleted) {
                newNum = srcNum.substring(0, newNum.length() - 1);
            }

            newNum = removeZeroAtHead(newNum);


        }
        if (newNum.length() == 0) {
            return "0";
        }
        return newNum;
    }

    private static String removeZeroAtHead(String newNum) {

        for (int i = 0; i < newNum.length() - 1; i++) {
            if (newNum.charAt(i) == '0') {
                newNum = newNum.substring(i + 1);
            }
        }
        return newNum;
    }

    public static void main(String[] args) {
        String newNum = deleteNNumMin("1", 1);
        System.out.println(newNum);
    }
}
