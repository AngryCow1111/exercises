package com.ac.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * WebAutoConfiguration
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/9
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
