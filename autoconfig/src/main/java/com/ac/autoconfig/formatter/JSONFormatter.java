package com.ac.autoconfig.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSONFormatter
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/13
 */
public class JSONFormatter implements Formatter {


    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(JSONFormatter.class);

    public JSONFormatter() {
        this(new ObjectMapper());
    }

    public JSONFormatter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String format(Object o) {
        try {

            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.info(e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
