package com.timotege;

import com.timotege.api.GiphyApi;
import com.timotege.dto.GifDTO;
import com.timotege.dto.GiphyResponseDTO;
import com.timotege.service.GiphyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GiphyServiceTest {
    @MockBean
    GiphyApi giphyApi;

    @Autowired
    private GiphyService giphyService;

    @Value("${giphy.service.id}")
    private String id;

    @Test
    public void getRichGifTest() {
        List<GifDTO> gifs = new ArrayList<GifDTO>();
        gifs.add(new GifDTO("www.timotege.com", "1"));
        gifs.add(new GifDTO("www.timotege.com", "2"));
        gifs.add(new GifDTO("www.timotege.com", "3"));
        Mockito.when(giphyApi.getGifs(id, "rich")).thenReturn(new GiphyResponseDTO(gifs));
        GifDTO gif = giphyService.getRichGif();
        Assertions.assertTrue(gif.getId().equals("1") || gif.getId().equals("2") || gif.getId().equals("3"));
    }

    @Test
    public void getBrokeGifTest() {
        List<GifDTO> gifs = new ArrayList<GifDTO>();
        gifs.add(new GifDTO("www.timotege.com", "1"));
        gifs.add(new GifDTO("www.timotege.com", "2"));
        gifs.add(new GifDTO("www.timotege.com", "3"));
        Mockito.when(giphyApi.getGifs(id, "broke")).thenReturn(new GiphyResponseDTO(gifs));
        GifDTO gif = giphyService.getBrokeGif();
        Assertions.assertTrue(gif.getId().equals("1") || gif.getId().equals("2") || gif.getId().equals("3"));
    }
}