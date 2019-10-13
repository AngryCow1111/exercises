package com.ac.springboot.conditionalconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ConditionalConfiguraionBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class ConditionalConfiguraionBootstrap {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World"};
        String[][] metricss = {{"1", "2"}, {"1", "2"}, {"1", "2"}};
//        List<String> stringList = Arrays.asList(strings)
//                .stream()
//                .map(str -> str.split(""))
//                .flatMap(str -> Arrays.stream(str))
//                .collect(Collectors.toList());
        List<String> stringList = Stream.of(metricss)
//                .flatMap(strings1 -> Arrays.stream(strings1))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
        // 设置系统language属性为chinese
        System.setProperty("language", "english");
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ConditionalMessageConfiguration.class);
        String messageBean = applicationContext.getBean("messageBean", String.class);
        System.out.println(messageBean);
        applicationContext.close();
    }
}
