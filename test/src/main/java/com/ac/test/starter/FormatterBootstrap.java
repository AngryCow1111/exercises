//package com.ac.test.starter;
//
//import org.springframework.beans.factory.NoSuchBeanDefinitionException;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import java.util.Formatter;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * FormatterBootstrap
// *
// * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
// * @since 2019/10/13
// */
//@EnableAutoConfiguration
//public class FormatterBootstrap {
//
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
//                .web(WebApplicationType.NONE)
//                .properties("formatter.enable=true")
//                .run();
//        Map data = new HashMap<>();
//        data.put("name", "李四");
//        Map<String, Formatter> beansOfType = context.getBeansOfType(Formatter.class);
//        if (beansOfType.isEmpty()) {
//            throw new NoSuchBeanDefinitionException("no such bean!!! ");
//        }
//        beansOfType.forEach((beanName, formatter) -> {
//
//            System.out.println(beanName + "," + formatter.getClass().getSimpleName() + "," + formatter.format(data));
//        });
//        context.close();
//    }
//
//}
