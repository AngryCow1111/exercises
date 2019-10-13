package com.ac.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * UserEventListener
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class UserEventListener implements ApplicationListener<GenericEvent<User>> {
    @Override
    public void onApplicationEvent(GenericEvent<User> event) {
        System.out.println("onApplicationEvent:" + event.getSource());
    }

    @EventListener
    public void onUserEvent(User event) {
        System.out.println("onUserEvent" + event);
    }
}
