package com.ac.springboot.profileconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.AbstractEnvironment;

/**
 * CalculationServiceBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */

@ComponentScan(basePackageClasses = CalculatingService.class)
public class CalculationServiceBootstrap {
    static {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "java8");
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "java7");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(CalculationServiceBootstrap.class);
        CalculatingService bean = applicationContext.getBean(CalculatingService.class);
        System.out.println(bean);
        bean.sum(1, 2, 3);
        applicationContext.close();
    }
}
