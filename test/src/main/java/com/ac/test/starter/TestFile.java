package com.ac.test.starter;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * TestFile
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2021/1/27
 */
public class TestFile {
    public static void main(String[] args) {
        try {
            File file = new File("content.properties");
            System.out.println(file.exists());
            DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
            Resource resource = defaultResourceLoader.getResource("content.properties");
            EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
            Reader reader = encodedResource.getReader();
            Properties properties = new Properties();
            properties.load(reader);
            System.out.println(properties);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
