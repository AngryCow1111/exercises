package com.ac.springframework.wiring;

import com.ac.springframework.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XmlWiringBean
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/1
 */
public class XmlWiringBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/user.xml");
        User user = context.getBean(User.class);
        context.close();
    }
}
