package com.ac.java8.jodatime;

import org.joda.time.DateTime;

import java.time.Clock;

/**
 * JodaTimeDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class JodaTimeDemo {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        DateTime newDateTime = dateTime.minusDays(2);
    }
}
