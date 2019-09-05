package com.ac.java8.datetime;


import java.time.Clock;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * DateTimeDemo
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-10
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Clock gmt = clock.withZone(ZoneId.ofOffset("GMT", ZoneOffset.of("+8")));
        long millisCustomized = gmt.millis();

    }
}
