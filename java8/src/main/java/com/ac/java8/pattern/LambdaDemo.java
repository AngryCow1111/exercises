package com.ac.java8.pattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * LambdaDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/7
 */
public class LambdaDemo {

    /**
     * SCFP+Action(supplier+consumer+function+predicate)
     */
    public static void main(String[] args) {
        PropertyChangeListener t1 = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };
        //  (evt) == evt
        PropertyChangeListener t2 = (evt) -> {
            println(evt);
        };

        PropertyChangeListener t3 = LambdaDemo::println;
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    /**
     * show action
     */
    private static void showAction() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        runnable.run();
    }
}
