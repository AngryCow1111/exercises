package com.ac.springboot.profileconfiguration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * NonLambdaServiceImpl
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@Profile("java7")
@Component
public class NonLambdaServiceImpl implements CalculatingService {
    @Override
    public void sum(Integer... values) {
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        System.out.println(String.format("java7 sum 结果是：%d", sum));
    }
}
