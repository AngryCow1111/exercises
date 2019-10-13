package com.ac.java8.code;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64Demo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class Base64Demo {
    public static void main(String[] args) {
        String srcStr = "hello world";
        String encodeStr = Base64.getEncoder().encodeToString(srcStr.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeStr);
        byte[] decode = Base64.getDecoder().decode(encodeStr);
        String decoderStr = new String(decode, StandardCharsets.UTF_8);
        System.out.println(decoderStr);
    }
}
