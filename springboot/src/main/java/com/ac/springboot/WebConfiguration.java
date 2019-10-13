package com.ac.springboot;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * WebConfiguration
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/9
 */
//@EnableAutoConfiguration
//@SpringBootApplication
@Configuration
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> helloword() {
        return route(GET("/helloworld"),
                request -> ok().body(Mono.just("helloworld"), String.class));
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前helloworld的实现类为：" +
                    beanFactory.getBean("helloword").getClass().getName());
            System.out.println("当前WebConfiguration的实现类为：" + beanFactory
                    .getBean("webConfiguration").getClass().getName());
        };
    }
}
