package com.undsf.amcl.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String writeValue(Object object) {
        try {
            return mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException ex) {
            log.warn("对象转JSON字符串失败");
        }
        return null;
    }

    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        }
        catch (JsonProcessingException ex) {
            log.warn("JSON字符串转对象失败：{}", json, ex);
        }
        return null;
    }

    public static <T> T readValue(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        }
        catch (JsonProcessingException ex) {
            log.warn("JSON字符串转对象失败：{}", json, ex);
        }
        return null;
    }
}
