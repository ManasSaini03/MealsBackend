package com.manas.meals.Cache;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CacheService {

    private static final long TTL = 10 * 60 * 1000; // 10 minutes
    private static final int MAX_ENTRIES = 100;

    private final Map<String, CacheEntry> cache =
            new LinkedHashMap<String, CacheEntry>(MAX_ENTRIES, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<String, CacheEntry> eldest) {
                    return size() > MAX_ENTRIES;
                }
            };

    public synchronized String get(String key) {
        CacheEntry entry = cache.get(key);

        if (entry == null) return null;

        if (System.currentTimeMillis() - entry.getTimestamp() > TTL) {
            cache.remove(key);
            return null;
        }

        return entry.getData();
    }

    public synchronized void put(String key, String data) {
        cache.put(key, new CacheEntry(data));
    }
}
