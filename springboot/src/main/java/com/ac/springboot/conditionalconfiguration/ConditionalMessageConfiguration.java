package com.ac.springboot.conditionalconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalMessageConfiguration
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@Configuration
public class ConditionalMessageConfiguration {

    @ConditionalOnSystemProperty(name = "language", value = "chinese")
    @Bean("messageBean")
    public String chineseMessage() {
        return "世界，你好啊！";
    }

    @ConditionalOnSystemProperty(name = "language", value = "english")
    @Bean("messageBean")
    public String englishMessage() {
        return "hello world!";
    }

}
