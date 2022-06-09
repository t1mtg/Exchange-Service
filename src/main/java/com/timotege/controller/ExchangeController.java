package com.timotege.controller;


import com.timotege.dto.GifDTO;
import com.timotege.exception.CurrencyNotFoundException;
import com.timotege.exception.GifNotFoundException;
import com.timotege.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/exchange")
@RestController
public class ExchangeController {
    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/get/{currency}")
    public GifDTO getGif(@PathVariable String currency) {
        return exchangeService.getGif(currency);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(CurrencyNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(GifNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(GifNotFoundException e) {
        return e.getMessage();
    }
}
