package com.estat.HelloMix.Controller;

import com.estat.HelloMix.Model.Movies.Movie;
import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import com.estat.HelloMix.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public Hashtable<String,Movie> getAllMovies()
    {
        return movieService.getAllMovies();
        //return null;
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable("id") String id)
    {
        return (movieService.getMovieById(id).isPresent()? movieService.getMovieById(id):movieService.fetchMovieById(id));
        //return movieService.fetchMovieById(id);
    }

}
