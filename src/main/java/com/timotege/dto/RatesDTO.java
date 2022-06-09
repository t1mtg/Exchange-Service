package com.timotege.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public class RatesDTO {
    public RatesDTO() {
    }

    public RatesDTO(String timestamp, String base, Map<String, BigDecimal> rates) {
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("base")
    private String base;
    @JsonProperty("rates")
    private Map<String, BigDecimal> rates;

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
