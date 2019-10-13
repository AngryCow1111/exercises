package com.ac.java8.newcharacter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.stream.Stream;

/**
 * FileStreamDemo
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/6
 */
public class FileStreamDemo {
    public static void main(String[] args) {
        Path path = new File("test.txt").toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> {
                System.out.println("Done");
            }).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
