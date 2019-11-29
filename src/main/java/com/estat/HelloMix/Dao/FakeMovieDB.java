package com.estat.HelloMix.Dao;

import org.springframework.stereotype.Repository;

@Repository("FakeDB")
public class FakeMovieDB implements MovieDao {
    @Override
    public List<Movie> getallMovies() {
        return null;
    }

    @Override
    public Movie getMovieByName() {
        return null;
    }

    @Override
    public void addMovieByName() {

    }

    @Override
    public void removeMovieByName() {

    }

    @Override
    public void editMovieById() {

    }
}
