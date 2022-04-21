package com.undsf.amcl.configs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssetInfo {
    @JsonProperty
    public long totalSize;

    @JsonProperty
    public String id;

    @JsonProperty
    public String url;

    @JsonProperty
    public String sha1;

    @JsonProperty
    public long size;
}
