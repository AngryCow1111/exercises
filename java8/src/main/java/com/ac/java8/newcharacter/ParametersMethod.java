package com.ac.java8.newcharacter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

/**
 * ParametersMethod
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class ParametersMethod {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ParametersMethod.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println(parameter.getName());
        }
    }
}
