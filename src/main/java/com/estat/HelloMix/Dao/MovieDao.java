package com.estat.HelloMix.Dao;

import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;

public interface MovieDao {

    public List<Non_Animated_MovieMovie> getallMovies();

    public Non_Animated_Movie getMovieByName();

    public void addMovieByName();

    public void removeMovieByName();

    public void editMovieById();
}
