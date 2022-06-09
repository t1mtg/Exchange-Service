package com.timotege.service;

import java.math.BigDecimal;

public interface OpenExchangeService {
    public BigDecimal getLatestValue(String currency);
    public BigDecimal getYesterdaysValue(String currency);
}
