package com.estat.HelloMix.Service.FetchFromAPI;

import com.estat.HelloMix.Model.Movies.Movie;

import java.util.Optional;

public class IMDB_fetchService implements fetchService {
    @Override
    public Optional<Movie> fetchMovieById(String id) {
        return Optional.empty();
    }
}
