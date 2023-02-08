package com.ac.designpattern.adapter;

/**
 * BeanFactory
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/14
 */
public class BeanFactory {

    public static void doProcess(Processor processor) {
        System.out.println("------");
    }

    public static void main(String[] args) {
        doProcess(new AdapterFilter(new Filter()));
    }
}
