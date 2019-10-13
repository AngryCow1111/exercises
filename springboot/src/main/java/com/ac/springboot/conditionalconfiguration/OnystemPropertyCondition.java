package com.ac.springboot.conditionalconfiguration;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * OnystemPropertyCondition
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
@Component
public class OnystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> AnnotationAttributes = metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propertyName = (String) AnnotationAttributes.getFirst("name");
        String propertyValue = (String) AnnotationAttributes.getFirst("value");
        if (StringUtils.equals(propertyValue, System.getProperty(propertyName))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
