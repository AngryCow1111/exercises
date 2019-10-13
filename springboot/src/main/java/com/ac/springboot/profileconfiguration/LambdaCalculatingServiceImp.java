package com.ac.springboot.profileconfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * LambdaCalculatingServiceImp
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@Profile("java8")
@Component
public class LambdaCalculatingServiceImp implements CalculatingService {
    @Override
    public void sum(Integer... values) {
        Integer sum = Stream.of(values)
                .reduce(0, Integer::sum);
        System.out.println(String.format("java8 sum 结果:%d", sum));
    }
}
