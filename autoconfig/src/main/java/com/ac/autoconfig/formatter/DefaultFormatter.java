package com.ac.autoconfig.formatter;

/**
 * DefaultFormatter
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class DefaultFormatter implements Formatter {
    @Override
    public String format(Object o) {
        return String.valueOf(o);
    }
}
