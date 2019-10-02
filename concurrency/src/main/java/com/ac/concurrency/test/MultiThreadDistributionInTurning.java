package com.ac.concurrency.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MultiThreadDistributionInTurning
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/30
 */
public class MultiThreadDistributionInTurning {

    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        distributeThread(5, "aa", null);
        distributeThread(10, "bb", conditionB);
        distributeThread(15, "cc", conditionC);
    }

    private static void distributeThread(int count, String threadName, Condition condition) {

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < count; i++) {
                    System.out.println("current running thread is thread " + threadName + "\tcount is " + i);
                }
                if (null != condition) {
                    condition.signal();
                }
            } finally {
                lock.unlock();
            }
        }, threadName).start();
    }
}
