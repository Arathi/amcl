package com.undsf.amcl.configs;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Configuration {
    @JsonProperty
    public String id;

    @JsonProperty
    public Arguments arguments;

    @JsonProperty
    public String mainClass;

    @JsonProperty
    public String jar;

    @JsonProperty
    public AssetInfo assetIndex;

    @JsonProperty
    public String assets;

    @JsonProperty
    public JavaVersion javaVersion;

    @JsonProperty
    public Map<String, AssetInfo> downloads;

    @JsonProperty
    public String type;

    @JsonProperty
    public String time;

    @JsonProperty
    public String releaseTime;

    @JsonProperty
    public int minimumLauncherVersion;

    @JsonProperty
    public boolean root;

    @JsonProperty
    public List<Configuration> patches;

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
        log.info("发现未能解析的成员{}", key);
    }
}
