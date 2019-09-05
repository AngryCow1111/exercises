package com.ac.jvm.gc;

/**
 * ReferenceGCDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-28
 */
public class ReferenceGCDemo {

    public Object instance = null;

    private byte[] bigSize = new byte[2 * 1024 * 1024];

    public static void main(String[] args) {
        ReferenceGCDemo referenceGCDemoA = new ReferenceGCDemo();
        ReferenceGCDemo referenceGCDemoB = new ReferenceGCDemo();

        referenceGCDemoA.instance = referenceGCDemoB;
        referenceGCDemoB.instance = referenceGCDemoA;
        /**
         * set the reference as null ,and it will be collected by gc. e.g.
         */
        referenceGCDemoA = null;
        referenceGCDemoB = null;

        /**
         * given this do gc，these can be collected whether or not.
         */
        System.gc();
    }
}
