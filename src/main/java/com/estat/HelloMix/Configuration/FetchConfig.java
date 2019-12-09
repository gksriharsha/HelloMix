package com.estat.HelloMix.Configuration;

import com.estat.HelloMix.Service.FetchFromAPI.IMDB_fetchService;
import com.estat.HelloMix.Service.FetchFromAPI.TMDB_fetchService;
import com.estat.HelloMix.Service.FetchFromAPI.fetchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FetchConfig {
    @Bean
    @Conditional(FetchTMDBCondition.class)
    public fetchService getTMDBfetcher()
    {
        return new TMDB_fetchService();
    }

    @Bean
    @Conditional(FetchIMDBCondition.class)
    public fetchService getIMDBfetcher()
    {
        return new IMDB_fetchService();
    }
}
