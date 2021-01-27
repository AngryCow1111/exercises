package com.ac.java8.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * TimeUtil
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yangui</a>
 * @since 2019/12/11
 */
public class TimeUtil {
    public static Date plusDays(Date date, int days) {
        if (date != null) {
            DateTime dateTime = new DateTime(date);
            DateTime plusDays = dateTime.plusDays(days);
            return plusDays.toDate();
        } else {
            return null;
        }
    }
}
