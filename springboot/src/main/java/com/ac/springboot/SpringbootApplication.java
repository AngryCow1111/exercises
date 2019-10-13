package com.ac.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@Component
public class SpringbootApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringbootApplication.class, args);

//        SpringApplication.run(WebConfiguration.class, args);
    }

    //    @Bean
    public RouterFunction<ServerResponse> helloword() {
        return route(GET("/helloworld"),
                request -> ok().body(Mono.just("helloworld"), String.class));
    }

    /***
     * ApplicationRunner#run方法的特性在springboot启动后会回调。
     * @param context
     * @return
     */
//    @Bean
//    public ApplicationRunner runner(WebServerApplicationContext context) {
////        return new ApplicationRunner() {
////            @Override
////            public void run(ApplicationArguments args) throws Exception {
////                System.out.println("当前webserver的实现类为:"+
////                        context.getWebServer().getClass().getName());
////            }
////        };
//
//        return args -> {
//            System.out.println("当前webserver的实现类为:" +
//                    context.getWebServer().getClass().getName());
//        };
//    }
    @EventListener(value = WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {

        System.out.println("当前webserver的实现类为：" + event.getWebServer().getClass().getName());

    }


}
