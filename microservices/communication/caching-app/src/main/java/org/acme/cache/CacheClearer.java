package org.acme.cache;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheManager;

import java.util.Optional;

@Singleton
public class CacheClearer {

    private final CacheManager cacheManager;

    public CacheClearer(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void clearCache(String cacheName) {
        Optional<Cache> cache = cacheManager.getCache(cacheName);
        if (cache.isPresent()) {
            cache.get().invalidateAll().await().indefinitely();
        }
    }
}
