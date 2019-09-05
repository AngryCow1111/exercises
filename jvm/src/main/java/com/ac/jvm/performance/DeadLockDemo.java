package com.ac.jvm.performance;

/**
 * DeadLockDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-02
 */
public class DeadLockDemo implements Runnable {
    int a, b;

    public DeadLockDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            Thread thread1 = new Thread(new DeadLockDemo(1, 2));
            Thread thread2 = new Thread(new DeadLockDemo(2, 1));
            thread1.start();
            thread2.start();

        }
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println("go go go");
            }
        }
    }
}
