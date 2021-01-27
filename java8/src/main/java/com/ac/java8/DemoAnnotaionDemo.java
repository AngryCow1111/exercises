package com.ac.java8;

/**
 * DemoAnnotaionDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/28
 */
@DemoAnnotation(value = "hehe")
public class DemoAnnotaionDemo {
    public static void main(String[] args) {
        DemoAnnotation annotation = DemoAnnotaionDemo.class.getAnnotation(DemoAnnotation.class);
        annotation.value();
    }
}
