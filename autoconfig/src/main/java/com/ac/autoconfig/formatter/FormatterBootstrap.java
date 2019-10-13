package com.ac.autoconfig.formatter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * FormatterBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@EnableAutoConfiguration
public class FormatterBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE)
                .run();
        Map<String, Object> data = new HashMap<>();
        data.put("name", "张三");
        Formatter bean = applicationContext.getBean(Formatter.class);
        System.out.println(bean.format(data));
        applicationContext.close();
    }
}
