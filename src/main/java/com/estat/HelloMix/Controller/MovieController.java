package com.estat.HelloMix.Controller;

import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import com.estat.HelloMix.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Non_Animated_Movie> getAllMovies()
    {
        return movieService.getAllMovies();
    }

}
