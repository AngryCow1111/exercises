package com.ac.springboot.enable;

import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.config.DelegatingWebFluxConfiguration;

import java.lang.annotation.*;

/**
 * EnableServer
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ServerImportBeanDefinitionRegistrar.class)
//@Import(ServerConfigurationSelector.class)
public @interface EnableServer {

    Server.Type type() default Server.Type.FTP;
}
