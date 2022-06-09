package com.timotege.service;

import com.timotege.dto.GifDTO;

public interface ExchangeService {
    GifDTO getGif(String currency);
}
