package com.estat.HelloMix.Dao;

import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@Component
public interface MovieDao {

    void addMovieByName(String name);

    void addMovieByObject(Non_Animated_Movie movie);

    Hashtable<String,Non_Animated_Movie> getAllMovies();

    Optional<Non_Animated_Movie> getMovieById(String id);

    void editMovieById();

    void removeMovieByName();
}
