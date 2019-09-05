package com.ac.jvm.oom;

/**
 * StackSofeTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class StackSofeTest {

    private int length;

    void stackLeak() {
        length++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSofeTest stackSofeTest = new StackSofeTest();

        try {
            stackSofeTest.stackLeak();
        } catch (StackOverflowError e) {
            e.printStackTrace();
            System.out.println(stackSofeTest.length);
        }
    }
}
