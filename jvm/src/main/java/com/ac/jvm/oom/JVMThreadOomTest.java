package com.ac.jvm.oom;

/**
 * JVMThreadOomTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class JVMThreadOomTest {

    public void dontStop() {

    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JVMThreadOomTest jvmThreadOomTest = new JVMThreadOomTest();
        jvmThreadOomTest.stackLeakByThread();

    }
}
