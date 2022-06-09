package com.timotege.service.impl;

import com.timotege.api.GiphyApi;
import com.timotege.dto.GifDTO;
import com.timotege.dto.GiphyResponseDTO;
import com.timotege.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GiphyServiceImpl implements GiphyService {
    private final GiphyApi giphyApi;

    @Autowired
    public GiphyServiceImpl(GiphyApi giphyApi) {
        this.giphyApi = giphyApi;
    }

    @Value("${giphy.service.id}")
    private String id;

    @Override
    public GifDTO getRichGif() {
        GiphyResponseDTO richGifs = giphyApi.getGifs(id, "rich");
        Random random = new Random();
        return richGifs.getData().get(random.nextInt(richGifs.getData().size()));
    }

    @Override
    public GifDTO getBrokeGif() {
        GiphyResponseDTO richGifs = giphyApi.getGifs(id, "broke");
        Random random = new Random();
        return richGifs.getData().get(random.nextInt(richGifs.getData().size()));
    }
}
