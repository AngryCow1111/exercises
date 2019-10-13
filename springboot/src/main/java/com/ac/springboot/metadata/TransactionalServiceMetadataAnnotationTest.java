package com.ac.springboot.metadata;

//import com.sun.tools.javac.util.ArrayUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.CollectionUtils;
//import sun.jvm.hotspot.oops.Metadata;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/**
 * TransactionalServiceMetadataAnnotationTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@TransactionalService
public class TransactionalServiceMetadataAnnotationTest {
    public static void main(String[] args) throws IOException {
        // 1.获取标注了测试注解的类的名称
        String className = TransactionalServiceMetadataAnnotationTest.class.getName();
        // 2. 获得MetadataReader工厂类
        MetadataReaderFactory factory = new CachingMetadataReaderFactory();
        // 3. 创建MetadataReader实例
        MetadataReader metadataReader = factory.getMetadataReader(className);
        // 4. 获取注解元数据类型信息并输出
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();

        annotationTypes.forEach(annotationType -> {
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);

            metaAnnotationTypes.forEach((metaAnnotationType) -> {
//                System.out.printf("注解%s 元标注%s\n", annotationType, metaAnnotationType);
                System.out.println(String.format("注解%s 元标注%s\n", annotationType, metaAnnotationType));
            });
        });

        // 2. 使用反射获取注解
        Annotation[] annotations = TransactionalServiceMetadataAnnotationTest.class.getAnnotations();
        if (annotations != null && annotations.length > 0) {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }
        }


    }
}
