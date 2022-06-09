package com.timotege.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GiphyResponseDTO {
    @JsonProperty("data")
    private List<GifDTO> data;

    public GiphyResponseDTO(List<GifDTO> data) {
        this.data = data;
    }

    public GiphyResponseDTO() {
    }

    public List<GifDTO> getData() {
        return data;
    }

    public void setData(List<GifDTO> data) {
        this.data = data;
    }
}
