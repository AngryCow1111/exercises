package com.ac.springboot.enable;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * EnableHelloworldBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@EnableHelloworld
public class EnableHelloworldBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(EnableHelloworldBootstrap.class);
        // 将当前引导类注册到上下文中
//        applicationContext.register(EnableHelloworldBootstrap.class);
        // 启动上下文
//        applicationContext.refresh();
        String helloworld = applicationContext.getBean("helloworld", String.class);
        System.out.println(helloworld);
        applicationContext.close();
    }
}
