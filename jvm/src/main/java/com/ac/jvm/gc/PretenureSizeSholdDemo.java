package com.ac.jvm.gc;

/**
 * PretenureSizeSholdDemo
 * a sample of PretenureSizeThreshold paramter process
 * when creating bigsize object
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-01
 */
public class PretenureSizeSholdDemo {
    /**
     * jvm paramters
     * <li>-verbose:gc
     * -Xms20m
     * -Xmx20m
     * -Xmn10m
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8 default
     * -XX:PretenureSizeThreshold=3145728
     * it is do for serial and parnew gc collcetor
     * </li>
     */
    private static final int _1M = 1024 * 1024;

    public static void testPretenureSizeShold() {
        byte[] allocation;
        /**
         * test this object whether at tenured gen not young gen.
         */
        allocation = new byte[4 * _1M];
    }

    public static void main(String[] args) {
        testPretenureSizeShold();
    }
}
