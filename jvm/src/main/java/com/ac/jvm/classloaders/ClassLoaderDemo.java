package com.ac.jvm.classloaders;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassLoaderDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019-09-03
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {


                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);

                    if (null == is) {
                        return super.loadClass(name);
                    }
                    byte[] byets = new byte[is.available()];
                    is.read(byets);
                    return defineClass(null, byets, 0, byets.length);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        Object object = classLoader.loadClass("ClassLoaderDemo");

        System.out.println(object instanceof ClassLoaderDemo);
    }
}
