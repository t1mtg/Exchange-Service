package com.timotege.service.impl;

import com.timotege.dto.GifDTO;
import com.timotege.exception.CurrencyNotFoundException;
import com.timotege.exception.GifNotFoundException;
import com.timotege.service.ExchangeService;
import com.timotege.service.GiphyService;
import com.timotege.service.OpenExchangeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    private final GiphyService giphyService;
    private final OpenExchangeService openExchangeService;

    public ExchangeServiceImpl(GiphyServiceImpl giphyService, OpenExchangeServiceImpl openExchangeService) {
        this.giphyService = giphyService;
        this.openExchangeService = openExchangeService;
    }

    @Override
    public GifDTO getGif(String currency) {
        BigDecimal currentValue = openExchangeService.getLatestValue(currency);
        BigDecimal yesterdaysValue = openExchangeService.getYesterdaysValue(currency);
        if (currentValue == null || yesterdaysValue == null) {
            throw new CurrencyNotFoundException();
        }
        BigDecimal diff = currentValue.subtract(yesterdaysValue);
        GifDTO result;
        if (diff.compareTo(BigDecimal.ZERO) > 0) {
            result = giphyService.getRichGif();
        } else {
            result = giphyService.getBrokeGif();
        }
        if (result == null) {
            throw new GifNotFoundException();
        }
        return result;
    }
}
