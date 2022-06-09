package com.timotege.service.impl;

import com.timotege.api.OpenExchangeApi;
import com.timotege.dto.RatesDTO;
import com.timotege.exception.CurrencyNotFoundException;
import com.timotege.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class OpenExchangeServiceImpl implements OpenExchangeService {
    private final OpenExchangeApi openExchangeApi;

    @Value("${openExchange.service.id}")
    private String id;

    @Value("${openExchange.service.baseCurrency}")
    private String baseCurrency;

    public OpenExchangeServiceImpl(OpenExchangeApi openExchangeApi) {
        this.openExchangeApi = openExchangeApi;
    }

    public BigDecimal getLatestValue(String currency) {
        RatesDTO ratesDTO = openExchangeApi.getCurrentCurrencies(id, baseCurrency);
        return ratesDTO.getRates().get(currency);
    }

    public BigDecimal getYesterdaysValue(String currency) {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        RatesDTO ratesDTO = openExchangeApi.getYesterdaysCurrencies(String.valueOf(yesterday), id, baseCurrency);
        return ratesDTO.getRates().get(currency);
    }
}
