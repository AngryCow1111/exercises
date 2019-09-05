package com.ac.jvm.gc;

/**
 * MaxTenuringThresholdDemo
 * a sample of maxTenuringThreshold
 * do
 * when it allocate memory.
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-01
 */
public class MaxTenuringThresholdDemo {
    private static final int _1M = 1024 * 1024;

//    public static void testMaxTenuringThreshold() {
//        byte[] allocation1, allocation2, allocation3;
//        allocation1 = new byte[_1M / 4];
//        allocation2 = new byte[4 * _1M];
//        allocation3 = new byte[4 * _1M];
//        allocation3 = null;
////        allocation3 = new byte[4 * _1M];
//
//
//    }

    public static void main(String[] args) {
//        testMaxTenuringThreshold();

        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4];
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];
    }
}
