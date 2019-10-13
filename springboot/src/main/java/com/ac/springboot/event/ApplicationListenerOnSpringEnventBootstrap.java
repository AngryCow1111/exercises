package com.ac.springboot.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * ApplicationListenerOnSpringEnventBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class ApplicationListenerOnSpringEnventBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new GenericApplicationContext();
        System.out.println("创建了上下文：" + context.getDisplayName());
        // 添加监听器
        context.addApplicationListener(event ->
                System.out.println("触发了事件：" + event.getClass().getSimpleName()));
        // 上下文就绪事件
        context.refresh();
        // 上下文停止事件
        context.stop();
        // 上下文开始事件
        context.start();

        context.close();
    }
}
