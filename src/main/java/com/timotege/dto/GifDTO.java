package com.timotege.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GifDTO {
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private String id;

    public GifDTO(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public GifDTO() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
