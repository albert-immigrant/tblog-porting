package com.tangzq.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

//import org.ehcache.config.CacheConfiguration;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;
//import org.ehcache.core.config.DefaultConfiguration;
//import org.ehcache.expiry.Duration;
//import org.ehcache.expiry.Expirations;
//import org.ehcache.jsr107.EhcacheCachingProvider;

//import org.springframework.cache.jcache.JCacheCacheManager;

//
//import javax.cache.CacheManager;
//import javax.cache.Caching;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//@Configuration
//@EnableCaching
//@AutoConfigureAfter(value = {MetricsConfiguration.class, DatabaseConfiguration.class})
//@AutoConfigureAfter(value = { DatabaseConfiguration.class})
//@Profile("!" + Constants.SPRING_PROFILE_FAST)
public class CacheConfigurations {

/*
    @Bean
    JCacheCacheManager jCacheCacheManager() {
        return new JCacheCacheManager(cacheManager())
    }

    @Bean(destroyMethod = 'close')
    CacheManager cacheManager() {
        CacheConfiguration cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object,
                Object,
                ResourcePoolsBuilder.heap(5)).
                withExpiry(Expirations.timeToLiveExpiration(new Duration(5, TimeUnit.SECONDS))).
                build();

        Map<String, CacheConfiguration> caches = ['person': cacheConfiguration];

        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider()
        DefaultConfiguration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader())

        return provider.getCacheManager(provider.getDefaultURI(), configuration)
    }
    */
}
