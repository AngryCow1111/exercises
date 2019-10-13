package com.ac.springboot.enable;

import org.springframework.stereotype.Component;

/**
 * Server
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
public interface Server {
    void start();

    void stop();

    enum Type {
        HTTP,
        FTP
    }

}
