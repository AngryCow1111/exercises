package com.ac.concurrency.deadlock;

/**
 * DeadLockDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/2
 */
public class DeadLockDemo {

    static String lockA = "lockA";
    static String lockB = "lockB";

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("当前获得：" + lockA);
                synchronized (lockB) {
                    System.out.println("当前获得：" + lockB);
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println("当前获得：" + lockA);
                synchronized (lockA) {
                    System.out.println("当前获得：" + lockB);
                }
            }

        }).start();

    }
}
