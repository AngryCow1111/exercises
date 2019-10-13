package com.ac.springboot.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * GenericUserEventBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class GenericUserEventBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(UserEventListener.class);
        context.refresh();
        GenericEvent<User> event = new GenericEvent<>(new User("李四"));
        context.publishEvent(event);
        context.publishEvent(new User("张三"));
        context.close();
    }
}
