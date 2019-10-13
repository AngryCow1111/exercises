package com.ac.springboot.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HelloworldConfiguration
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@Configuration
public class HelloworldConfiguration {

    @Bean("helloworld")
    public String helloworld() {
        return "helloworld";
    }
}
