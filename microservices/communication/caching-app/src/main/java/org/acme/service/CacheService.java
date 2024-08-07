package org.acme.service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.quarkus.cache.CaffeineCache;

import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class CacheService {

    @CacheName("my-cache")
    Cache cache;

    @PostConstruct
    public void initialize() {
        cache.as(CaffeineCache.class).put("foo", CompletableFuture.completedFuture("bar"));
    }
}
