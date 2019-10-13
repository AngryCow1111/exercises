package com.ac.springboot.metadata;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TransactionalServiceReflectionBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@TransactionalService(value = "test")
public class TransactionalServiceReflectionBootstrap {
    public static void main(String[] args) {
        // 获得当前类的一个AnnotatedElement对象
        AnnotatedElement annotatedElement = TransactionalServiceReflectionBootstrap.class;
        // 获得AnnotatedElement对象的注解
        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
        // 利用反射来获取注解属性信息
//        ReflectionUtils.doWithMethods(TransactionalService.class, method ->
//                        System.out.println(String.format("@TransactionalService.%s=%s", method.getName(),
//                                ReflectionUtils.invokeMethod(method, transactionalService)))
//                , method ->
//                        !method.getDeclaringClass().equals(Annotation.class)
//        );
        // 递归获取所有的元注解
        Set<Annotation> metaAnnotations = getAllMetaAnnotations(transactionalService);
        metaAnnotations.stream()
                .forEach(TransactionalServiceReflectionBootstrap::printAnnotationAttributions);
    }

    private static void printAnnotationAttributions(Annotation annotation) {
        Class annotationType = annotation.annotationType();
        // 通过反射获取当前注解的所有属性
        ReflectionUtils.doWithMethods(annotationType, method ->
                        System.out.println(String.format("@%s.%s()=%s", annotationType.getSimpleName(),
                                method.getName(),
                                ReflectionUtils.invokeMethod(method, annotation))),
                method -> !method.getDeclaringClass().equals(Annotation.class));
        //method -> method.getParameterCount() == 0);
    }

    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
        // 获得该注解上的所以注解
        Annotation[] metaAnnotations = annotation.annotationType().getAnnotations();
        // 没有获得注解
        if (ObjectUtils.isEmpty(metaAnnotations)) {
            return Collections.emptySet();
        }
        // 过滤获得所以非java注解
        Set<Annotation> filteredMetaAnnotations = Stream.of(metaAnnotations)
                .filter(metaAnnotation -> !Target.class.getPackage().getName()
                        .equals(metaAnnotation.annotationType().getPackage().getName()))
                .collect(Collectors.toSet());
        // 递归查询所有元注解
        Set<Annotation> metaMetaAnnotations = filteredMetaAnnotations.stream()
                .map(TransactionalServiceReflectionBootstrap::getAllMetaAnnotations)
                .collect(HashSet<Annotation>::new, Set::addAll, Set::addAll);
        filteredMetaAnnotations.addAll(metaMetaAnnotations);
        return filteredMetaAnnotations;
    }


}
