package com.ac.java8.Map;

import java.lang.reflect.Method;

/**
 * ImpLRUWithLInkedHashMap
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-13
 */
public class ImpLRUWithLInkedHashMap {

    public String say(String content) {
        if (content.contains("哈哈")) {
            throw new RuntimeException("1111222");
        }
        return "2222";
    }

    public static void main(String[] args) {

        try {
            Method method = ImpLRUWithLInkedHashMap.class.getMethod("say", String.class);
            Object invoke = method.invoke("哈哈");
            System.out.println(invoke);
        } catch (RuntimeException e) {
            System.out.println("3333333");
        } catch (Exception e) {
            System.out.println("4444444");
        }

        System.out.println("execute to here！");

    }
}
