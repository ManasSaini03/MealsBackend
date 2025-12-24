package com.manas.meals.Services;

import com.manas.meals.Cache.CacheService;
import com.manas.meals.Clients.TheMealDbClient;
import com.manas.meals.Clients.Constants;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final TheMealDbClient client;
    private final CacheService cache;

    public MealService(TheMealDbClient client,CacheService cache) {
        this.client = client;
        this.cache = cache;
    }

    public String searchByName(String name) {
        String url = String.format(Constants.SEARCH_BY_NAME, name);
        return fetchWithCache(url);
    }

    public String getById(String id) {
        String url = String.format(Constants.LOOKUP_BY_ID, id);
        return fetchWithCache(url);
    }

    public String getCategories() {
        return fetchWithCache(Constants.CATEGORIES);
    }

    public String getByCategory(String category) {
        String url = String.format(Constants.FILTER_BY_CATEGORY, category);
        return fetchWithCache(url);
    }

    public String getRandomMeal() {
        return client.get(Constants.RANDOM_MEAL);
//        return fetchWithCache(Constants.RANDOM_MEAL);
    }

    private String fetchWithCache(String url) {
        String cached = cache.get(url);
        if (cached != null) return cached;

        String response = client.get(url);
        cache.put(url, response);
        return response;
    }
}
