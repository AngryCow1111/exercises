package com.ac.springboot.spi;

import javax.servlet.ServletContext;

/**
 * MyListContainerInitializer
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
class MyListContainerInitalizer implements MyContainerInitalizer {
    @Override
    public void onStartup(ServletContext context) {
        context.setAttribute("MyListContainerInitalizer", this);
        System.out.println("MyListContainerInitalizer Init ...");
    }
}

