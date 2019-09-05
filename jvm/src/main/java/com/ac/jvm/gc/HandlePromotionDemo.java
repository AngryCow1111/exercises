package com.ac.jvm.gc;

import java.util.Map;

/**
 * HandlePromotionDemo
 * a sample of promotion handle in gc collection action
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-02
 */
public class HandlePromotionDemo {

    private final static int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation4, allocation3, allocation5, allocation6, allocation7;
        allocation1 = new byte[_1M * 2];
        allocation2 = new byte[_1M * 2];
        allocation3 = new byte[_1M * 2];
        allocation1 = null;
        allocation5 = new byte[_1M * 2];
        allocation4 = new byte[_1M * 2];
        allocation6 = new byte[_1M * 2];
        allocation3 = null;
        allocation4 = null;
        allocation5 = null;
        allocation7 = new byte[_1M * 2];

        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        for (Thread thread : allStackTraces.keySet()) {
            StackTraceElement[] stackTraceElements = allStackTraces.get(thread);
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.println("线程：" + thread.getName());

            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println(stackTraceElement);
            }
        }
    }
}
