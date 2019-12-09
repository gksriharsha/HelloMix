package com.estat.HelloMix.Service;

import com.estat.HelloMix.Dao.MovieDao;
import com.estat.HelloMix.Model.Movies.*;
import com.estat.HelloMix.Service.FetchFromAPI.fetchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.Character;
import java.text.DecimalFormat;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    @Qualifier("FakeDB")
    MovieDao movieDao;

    @Autowired
    private fetchService fetcher;
    public Hashtable<String,Movie> getAllMovies()
    {
        return movieDao.getAllMovies();
    }

    public Optional<Movie> getMovieById(String id)
    {
        return movieDao.getMovieById(id);
    }
    public Optional<Movie> fetchMovieById(String id)
    {
        Optional<Movie> hasmovie = fetcher.fetchMovieById(id);
        if(hasmovie.isPresent()) {
            Movie movie = hasmovie.get();
            movieDao.addMovieByObject(movie);
        }
        return hasmovie;
    }
}
