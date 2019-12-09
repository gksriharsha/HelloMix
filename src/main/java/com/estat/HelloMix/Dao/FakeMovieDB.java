package com.estat.HelloMix.Dao;

import com.estat.HelloMix.Model.Movies.Movie;
import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import com.estat.HelloMix.Model.Movies.Producer;
import com.estat.HelloMix.Model.Movies.ProductionCompany;
import com.estat.HelloMix.Service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.*;

@Repository("FakeDB")
public class FakeMovieDB implements MovieDao {

    @Autowired
    MovieService movieService;

    private Hashtable<String, Movie> DB;

    public FakeMovieDB()
    {
        DB = new Hashtable<>();
    }

    private void preloadMovies() throws Exception
    {
        List<Movie> movies = new ArrayList<>();
        List<String> movie_ids = new ArrayList<>();
        Optional<Movie> movie;
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
    }

    @Override
    public void addMovieByObject(Movie movie) {
        DB.put(movie.getIds().get("TMDB_id").toString(),movie);
        try {
            System.out.println(movie.checkNull());
        }
        catch(Exception e)
        {
            System.out.println("Nope");
        }
    }

    @Override
    public Hashtable<String,Movie> getAllMovies() {
        if(DB.isEmpty()) {
            List<Movie> movies = new ArrayList<>();
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
    public Optional<Movie> getMovieById(String id) {
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
