package com.ac.springboot.conditionalconfiguration;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * ConditionalOnSystemProperty
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    String name();

    String value();
}
