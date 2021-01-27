package com.ac.java8.shareknowledge.functionalinterface;

/**
 * FunctionDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/29
 */
public class FunctionDemo {

    public static void main(String[] args) {

        FunctionalInterface3 functionalInterface1 = () -> {
            System.out.println("FunctionalInterface3 execute");
        };

    }

    @FunctionalInterface
    public interface FunctionalInterface1 {
        void execute();
//        void execute2();

        // 只能有一个抽象方法
//        void execute1();
        default void execute3() {

        }
    }

    // @FunctionalInterface 不是必需的 只要满足一定模式即可。
    public interface FunctionalInterface2 {
        void execute();

        default void execute1() {

        }
    }

    public interface FunctionalInterface3 {
        void execute();
//        void execute1();
    }

}


