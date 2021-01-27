package com.ac.java8.shareknowledge.functionalinterface;

import sun.tools.jstat.Literal;

import java.util.function.Consumer;

/**
 * ActionDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class ActionDemo {
    public static void main(String[] args) {
        //匿名内部类方式
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        // lombda方式
        Runnable runnable2 = () -> {
//            System.out.println("hello world");
            Consumer<String> print1 = ActionDemo::print1;
            print1.accept("hello world");
        };
        runnable2.run();
    }

    public static void print1(String message) {
        System.out.println(message);
    }



}
