package com.ac.jvm.gc;

/**
 * MaxTenuringThresholdDemo2
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-01
 */
public class MaxTenuringThresholdDemo2 {


    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1M / 6];
        allocation2 = new byte[_1M / 6
                ];
        allocation3 = new byte[_1M * 4];
        allocation4 = new byte[_1M * 4];
//        System.gc();
        /**
         * set allocation4 as null to tripper a minor gc
         */
        allocation4 = null;
        allocation4 = new byte[_1M * 4];

    }
}
