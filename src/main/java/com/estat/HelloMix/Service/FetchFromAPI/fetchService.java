package com.estat.HelloMix.Service.FetchFromAPI;

import com.estat.HelloMix.Model.Movies.Movie;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public interface fetchService {
    public Optional<Movie> fetchMovieById(String id);
}
