package com.estat.HelloMix.Dao;

import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import com.estat.HelloMix.Model.Movies.Producer;
import com.estat.HelloMix.Model.Movies.ProductionCompany;
import com.estat.HelloMix.Service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Repository("FakeDB")
public class FakeMovieDB implements MovieDao {

    @Autowired
    MovieService movieService;

    private Hashtable<String, Non_Animated_Movie> DB;

    public FakeMovieDB()
    {
        DB = new Hashtable<>();
    }

    private Hashtable<String,Non_Animated_Movie> preloadMovies() throws Exception
    {
        List<Non_Animated_Movie> movies = new ArrayList<>();
        List<String> movie_ids = new ArrayList<>();
        Optional<Non_Animated_Movie> movie;
        String base_url = "";
        movie_ids.add(24428+"");
        movie_ids.add(99861+"");
        movie_ids.add(14611+"");
        movie_ids.add(14609+"");
        movie_ids.add(109088+"");

        for(String id:movie_ids)
        {
            movie = movieService.fetchMovieById(id);
            if(movie.isPresent()) {
                System.out.println(id);
                if (!DB.contains(movie)) {
                    DB.put(movie.get().getIds().get("TMDB_id").toString(), movie.get());
                }
                //DB.put((int)result["id"],)
                movies.add(movie.get());
            }
            else
            {
                movies.add(new Non_Animated_Movie());
            }
        }
        return DB;
    }

    @Override
    public void addMovieByObject(Non_Animated_Movie movie) {
        DB.put(movie.getIds().get("TMDB_id").toString(),movie);
    }

    @Override
    public Hashtable<String,Non_Animated_Movie> getAllMovies() {
        if(DB.isEmpty()) {
            List<Non_Animated_Movie> movies = new ArrayList<>();
            try {
                preloadMovies();
                return DB;
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }
        else
        {
            return DB;
        }
    }

    @Override
    public Optional<Non_Animated_Movie> getMovieById(String id) {
        return Optional.ofNullable(DB.get(id));
    }

    @Override
    public void addMovieByName(String name) {

    }

    @Override
    public void removeMovieByName() {

    }

    @Override
    public void editMovieById() {

    }

}
