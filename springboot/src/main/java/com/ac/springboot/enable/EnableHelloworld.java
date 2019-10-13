package com.ac.springboot.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableHelloworld
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloworldConfiguration.class)
public @interface EnableHelloworld {
}
