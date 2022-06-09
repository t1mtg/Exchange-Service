package com.timotege.api;

import com.timotege.dto.RatesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${openExchange.service.name}", url = "${openExchange.service.url}")
public interface OpenExchangeApi {
    @GetMapping("/api/latest.json")
    RatesDTO getCurrentCurrencies(@RequestParam(name = "app_id") String id,
                                  @RequestParam(name = "base") String currency);

    @GetMapping("/api/historical/{date}.json")
    RatesDTO getYesterdaysCurrencies(@PathVariable String date,
                                     @RequestParam(name = "app_id") String id,
                                     @RequestParam(name = "base") String currency);
}
