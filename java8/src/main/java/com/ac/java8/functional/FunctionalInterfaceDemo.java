package com.ac.java8.functional;

/**
 * FunctionalInterfaceDeom
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-22
 */
public class FunctionalInterfaceDemo {

    @FunctionalInterface
    public interface function1 {
        void execute();

        default String getDescription() {
            return String.valueOf(this);
        }
    }

    public interface function2 {
        void execute();
    }
}
