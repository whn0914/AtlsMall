package com.atlsmall.handler;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.miemiedev.mybatis.paginator.jackson2.PageListJsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by sxw on 2015/9/28.
 *
 * 1、支持mybatis的分页行为
 * 2、打印请求的响应结果
 *
 */
public class CustomObjectMapper extends PageListJsonMapper {
    private static final Logger logger = LoggerFactory.getLogger(CustomObjectMapper.class);

    @Override
    public void writeValue(JsonGenerator jgen, Object value) throws IOException, JsonGenerationException, JsonMappingException {
        super.writeValue(jgen, value);
        logger.debug("响应结果:{}", writeValueAsString(value));
    }
}
