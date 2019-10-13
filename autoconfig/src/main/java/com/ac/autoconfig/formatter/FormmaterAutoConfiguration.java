package com.ac.autoconfig.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FormmaterAutoConfiguration
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@Configuration
@ConditionalOnProperty(prefix = "formatter", havingValue = "true", name = "enable")
public class FormmaterAutoConfiguration {

    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    @Bean
    public Formatter defaultFormatter() {
        return new DefaultFormatter();
    }

    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    @Bean
    public Formatter jsonFormatter() {
        return new JSONFormatter();
    }

    @ConditionalOnBean(ObjectMapper.class)
    @Bean
    public Formatter objectMapperFormatter(ObjectMapper objectMapper) {

        return new JSONFormatter(objectMapper);
    }
}
