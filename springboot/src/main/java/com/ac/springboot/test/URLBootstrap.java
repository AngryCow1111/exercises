package com.ac.springboot.test;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * URLBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class URLBootstrap {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://github.com/angrycow1111");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        StreamUtils.copy(inputStream,System.out);
    }
}
