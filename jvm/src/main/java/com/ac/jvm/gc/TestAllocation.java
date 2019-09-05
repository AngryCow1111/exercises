package com.ac.jvm.gc;

/**
 * TestAllocation
 * a simple sample to watch what happen during create object.
 * e.g. memory allocation rules and collection strategies.
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-01
 */
public class TestAllocation {


    /**
     * <p>
     * given a case:
     * set max and min size of heap as 20m to avoid to expand heap.
     * <li>-Xmx20m -Xms 20m
     * -Xmn10m
     * </li>
     * allocation 10m for young gen,
     * <li> -verbose:gc -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=2
     * </li>
     * watching gc log to recognize progress of object creation.
     * </p>
     */

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
//        byte[] location1, location2, location3, location4;
//
//        location1 = new byte[2 * _1M];
//        location2 = new byte[2 * _1M];
//        location3 = new byte[2 * _1M];
//
//        /**
//         * happen a minor gc
//         */
//        location4 = new byte[5 * _1M];
    }
}
