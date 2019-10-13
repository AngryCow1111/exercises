package com.ac.springboot.metadata;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * TransactionalServiceASMBootstrap
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/11
 */
@TransactionalService
public class TransactionalServiceASMBootstrap {
    public static void main(String[] args) throws IOException {
        MetadataReaderFactory factory = new SimpleMetadataReaderFactory();
        String clazzName = TransactionalServiceASMBootstrap.class.getName();
        MetadataReader metadataReader = factory.getMetadataReader(clazzName);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();

        annotationTypes.stream()
                .forEach(annotationType -> {
                    Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);

                });

    }
}
