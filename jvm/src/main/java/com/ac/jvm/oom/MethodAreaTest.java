package com.ac.jvm.oom;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * MethodAreaTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-08-26
 */
public class MethodAreaTest {
    static class OomObject {
        public OomObject() {

        }
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OomObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    (MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args)
            );

            enhancer.create();
        }
    }
}
