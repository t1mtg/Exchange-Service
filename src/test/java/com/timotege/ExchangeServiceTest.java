package com.timotege;

import com.timotege.api.OpenExchangeApi;
import com.timotege.dto.RatesDTO;
import com.timotege.service.OpenExchangeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class ExchangeServiceTest {
    @MockBean
    OpenExchangeApi openExchangeApi;
    @Autowired
    private OpenExchangeService openExchangeService;

    @Value("${openExchange.service.id}")
    private String id;

    @Value("${openExchange.service.baseCurrency}")
    private String baseCurrency;

    @Test
    public void getLatestValueTest() {
        Map<String, BigDecimal> rates = new HashMap<>();
        rates.put("RUB", new BigDecimal("60"));
        rates.put("EUR", new BigDecimal("0.9"));
        Mockito.when(openExchangeApi.getCurrentCurrencies(id, baseCurrency))
                .thenReturn(new RatesDTO("1000", baseCurrency, rates));
        BigDecimal value = openExchangeService.getLatestValue("RUB");
        Assertions.assertEquals(value, new BigDecimal("60"));
    }
}