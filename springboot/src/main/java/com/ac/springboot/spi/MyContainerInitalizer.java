package com.ac.springboot.spi;

import javax.servlet.ServletContext;

/**
 * MyContainerInitalizer
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public interface MyContainerInitalizer {
    void onStartup(ServletContext context);
}
