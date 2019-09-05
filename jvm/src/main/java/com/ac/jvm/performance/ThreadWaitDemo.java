package com.ac.jvm.performance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ThreadWaitDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-02
 */
public class ThreadWaitDemo {


    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                ;
            }

        }, "busyThread");

        thread.start();
    }

    public static void createLockedThread(final Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "lockedThrea");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        /**
         * dead circle
         */
        createBusyThread();
        reader.readLine();
        /**
         * create a lock object
         */
        Object lock = new Object();
        createLockedThread(lock);

    }
}
