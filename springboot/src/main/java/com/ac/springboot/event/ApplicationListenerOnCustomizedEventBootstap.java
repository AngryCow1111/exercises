package com.ac.springboot.event;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ApplicationListenerOnCustomizedEventBootstap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class ApplicationListenerOnCustomizedEventBootstap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.addApplicationListener(new MyListenr());
        context.registerBean(MyAsyncListenr.class);

        context.refresh();
//        context.publishEvent(new MyEvent("hello world"));
//        context.publishEvent(new MyEvent("hello world2"));
    }

    static class MyEvent extends ApplicationEvent {
        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyEvent(Object source) {
            super(source);
        }
    }

    //    static class MyListenr implements ApplicationListener<MyEvent> {
//
//        @Override
//        public void onApplicationEvent(MyEvent event) {
//            System.out.println(event.getClass().getSimpleName());
//        }
//    }
    public static abstract class AbstractListenr {

        @EventListener
        public void onApplicationEvent1(ApplicationEvent event) {
            System.out.println(event.getClass().getSimpleName());
        }
    }

    public static class MyListenr extends AbstractListenr {

        @EventListener(ContextClosedEvent.class)
        public void onApplicationEvent1(ContextClosedEvent event) {
            System.out.println(event.getClass().getSimpleName());
        }
    }

    @EnableAsync
    public static class MyAsyncListenr {

        @EventListener
        @Async
        public void onApplicationEvent1(ApplicationEvent event) {
            System.out.println(event.getClass().getSimpleName());
            print();
        }
    }

    static void print() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }
}


