package com.manas.meals.Clients;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TheMealDbClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
