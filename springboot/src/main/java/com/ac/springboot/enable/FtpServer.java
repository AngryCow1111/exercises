package com.ac.springboot.enable;

import org.springframework.stereotype.Component;

/**
 * FtpServer
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@Component
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("Ftp start");
    }

    @Override
    public void stop() {
        System.out.println("Ftp stop");
    }
}
