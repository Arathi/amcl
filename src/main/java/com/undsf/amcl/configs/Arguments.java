package com.undsf.amcl.configs;

import com.fasterxml.jackson.annotation.*;
import com.undsf.amcl.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Arguments {
    @JsonIgnore
    public List<Argument> game;

    @JsonIgnore
    public List<Argument> jvm;

    @JsonIgnore
    public Map<String, Object> otherProperties;

    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return otherProperties;
    }

    @JsonAnySetter
    public void setOtherProperty(String key, Object value) {
        if (otherProperties == null) {
            otherProperties = new LinkedHashMap<>();
        }
        this.otherProperties.put(key, value);
        log.info("arguments中发现未能解析的成员{}", key);
    }

    @JsonSetter("game")
    public void setGame(List<Object> values) {
        game = new ArrayList<>();
        setArguments(values, game);
    }

    @JsonSetter("jvm")
    public void setJvm(List<Object> values) {
        jvm = new ArrayList<>();
        setArguments(values, jvm);
    }

    public void setArguments(List<Object> values, List<Argument> arguments) {
        for (Object value : values) {
            if (value instanceof String) {
                arguments.add(new Argument((String) value));
            }
            else if (value instanceof Map) {
                // log.info("读取到Map");
                String json = JsonUtil.writeValue(value);
                Argument argument = JsonUtil.readValue(json, Argument.class);
                arguments.add(argument);
            }
        }
        log.info("读取到成员{}个", arguments.size());
    }
}
