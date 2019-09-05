package com.ac.java8;

import java.io.InputStream;

/**
 * TestReadFile
 *
 * @author <a href="mailto:yanghui@pingtiao.com">yanghui</a>
 * @since 2019-08-18
 */
public class TestReadFile {

    public static void main(String[] args) {
        InputStream resourceAsStream = TestReadFile.class.getResourceAsStream("data.txt");
    }
}
