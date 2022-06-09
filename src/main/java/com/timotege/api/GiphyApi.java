package com.timotege.api;

import com.timotege.dto.GifDTO;
import com.timotege.dto.GiphyResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${giphy.service.name}", url = "${giphy.service.url}")
public interface GiphyApi {
    @GetMapping("/v1/gifs/search")
    GiphyResponseDTO getGifs(@RequestParam(name = "api_key", defaultValue = "${giphy.service.id}") String id,
                             @RequestParam(name = "q") String q);
}