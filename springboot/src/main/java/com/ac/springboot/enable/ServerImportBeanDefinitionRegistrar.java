package com.ac.springboot.enable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.stream.Stream;

/**
 * ServerImportBeanDefinitionRegistrar
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ServerConfigurationSelector serverConfigurationSelector = new ServerConfigurationSelector();
        String[] strings = serverConfigurationSelector.selectImports(importingClassMetadata);
        Stream.of(strings)
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> {
//                    registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
                });
    }
}
