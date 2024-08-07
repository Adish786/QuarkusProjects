package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.quarkus.cache.CaffeineCache;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class CacheKeysService {

    @CacheName("my-cache")
    Cache cache;

    /*
    public Set<Object> getAllCacheKeys() {
        return cache.as(CaffeineCache.class).keySet();
    }
     */
    public CompletableFuture<Object> getIfPresent(Object key) {
        return cache.as(CaffeineCache.class).getIfPresent(key);
    }


}
