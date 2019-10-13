package com.ac.springboot.enable;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Objects;

/**
 * ServerConfigurationSelector
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/12
 */

public class ServerConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 获得注解上的所有属性
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        // 获得type属性
        Server.Type type = (Server.Type) annotationAttributes.get("type");

        String[] imports = new String[0];
        if (Objects.isNull(type)) {
            return imports;
        }
        switch (type) {
            case FTP:
                imports = new String[]{FtpServer.class.getName()};
                break;
            case HTTP:
                imports = new String[]{HttpServer.class.getName()};
                break;
            default:
                imports = new String[]{HttpServer.class.getName()};
        }
        return imports;
    }
}
