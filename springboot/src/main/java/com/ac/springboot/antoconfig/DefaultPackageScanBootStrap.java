//package com.ac.springboot.antoconfig;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//import java.util.stream.Stream;
//
///**
// * DefaultPackageScanBootStrap
// *
// * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
// * @since 2019/10/13
// */
//@ComponentScan(basePackageClasses = DefaultPackageScanBootStrap.class)
//public class DefaultPackageScanBootStrap {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(DefaultPackageScanBootStrap.class);
//        Stream.of(applicationContext.getBeanDefinitionNames())
//                .forEach(System.out::println);
//    }
//}
