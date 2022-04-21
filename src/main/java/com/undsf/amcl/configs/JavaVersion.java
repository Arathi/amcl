package com.undsf.amcl.configs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JavaVersion {
    @JsonProperty
    public String component;

    @JsonProperty
    public int majorVersion;
}
