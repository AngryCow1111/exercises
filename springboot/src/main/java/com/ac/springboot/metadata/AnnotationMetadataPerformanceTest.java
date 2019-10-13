package com.ac.springboot.metadata;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * AnnotationMetadataPerformanceTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@TransactionalService
public class AnnotationMetadataPerformanceTest {
    public static void main(String[] args) throws IOException {
        AnnotationMetadata standardAnnotationMetadata = new StandardAnnotationMetadata(TransactionalService.class);
        MetadataReaderFactory factory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = factory.getMetadataReader(TransactionalService.class.getName());
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 执行次数
        int times = 10 * 10000;
        testAnnoationMetadataPerformance(times, annotationMetadata);
        testAnnoationMetadataPerformance(times, standardAnnotationMetadata);
        times = 100 * 10000;
        testAnnoationMetadataPerformance(times, annotationMetadata);
        testAnnoationMetadataPerformance(times, standardAnnotationMetadata);
        times = 1000 * 10000;
        testAnnoationMetadataPerformance(times, annotationMetadata);
        testAnnoationMetadataPerformance(times, standardAnnotationMetadata);
        times = 10000 * 10000;
        testAnnoationMetadataPerformance(times, annotationMetadata);
        testAnnoationMetadataPerformance(times, standardAnnotationMetadata);
    }

    /**
     * @param times              execution times
     * @param annotationMetadata given {@see AnnotationMetadata} object which should be tested
     */
    private static void testAnnoationMetadataPerformance(int times, AnnotationMetadata annotationMetadata) {

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            annotationMetadata.getAnnotationTypes();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("执行了%s次,耗时%s", times, endTime - beginTime));

    }
}
