package com.ac.springboot.metadata;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.AnnotatedElement;

/**
 * AnnotationAttributesBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@TransactionalService(value = "test")
public class AnnotationAttributesBootstrap {
    public static void main(String[] args) {
        AnnotatedElement annotatedElement = TransactionalService.class;
//        AnnotatedElement annotatedElement = TransactionalServiceBean.class;
        AnnotationAttributes serviceAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);
        AnnotationAttributes transactionalAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Transactional.class);

        print(serviceAttributes);
        print(transactionalAttributes);

    }

    private static void print(AnnotationAttributes annotationAttributes) {
        System.out.println(String.format("%s注解的属性集合", annotationAttributes.annotationType().getName()));
        // 遍历注解的属性集合
        annotationAttributes.forEach((name, value) -> {
            System.out.println(String.format("属性%s:%s", name, value));
        });
    }
}
