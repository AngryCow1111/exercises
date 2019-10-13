package com.ac.springboot.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * EnableServerBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@Configuration
@EnableServer(type = Server.Type.HTTP)
public class EnableServerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        applicationContext.register(EnableServerBootstrap.class);
        applicationContext.refresh();
        Server server = applicationContext.getBean(Server.class);
        System.out.println(server);
        server.start();
        server.stop();
        applicationContext.close();
    }
}
