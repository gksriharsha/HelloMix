package com.estat.HelloMix.Service;

import com.estat.HelloMix.Dao.MovieDao;
import com.estat.HelloMix.Model.Movies.Animation_Movie;
import com.estat.HelloMix.Model.Movies.Director;
import com.estat.HelloMix.Model.Movies.Non_Animated_Movie;
import com.estat.HelloMix.Model.Movies.ProductionCompany;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    @Qualifier("FakeDB")
    MovieDao movieDao;
    private static DecimalFormat df = new DecimalFormat("0.00");
    public Hashtable<String,Non_Animated_Movie> getAllMovies()
    {
        return movieDao.getAllMovies();
    }

    public Optional<Non_Animated_Movie> fetchMovieById(String id)
    {
        Non_Animated_Movie movie = new Non_Animated_Movie();
        String uri = "https://api.themoviedb.org/3/movie/{movie_id}?api_key=9cfd3c4aa5e5bb9c627e6e14501fe75e&language=en-US";
        String get_uri ="";
        Dictionary<String,String> ids = new Hashtable<>();
        ProductionCompany productionCompany = new ProductionCompany();
        Director director = new Director();
        get_uri = uri.replace("{movie_id}",id);
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(get_uri, String.class);
        try {

            HashMap<String, Object> response = (HashMap<String, Object>) new ObjectMapper().readValue(result, HashMap.class);

            if(response.containsKey("status_code") && response.get("status_code").equals("34"))
                return Optional.empty();
            movie.setTitle(response.get("original_title").toString());
            movie.setBudget(Float.parseFloat(df.format((Float.parseFloat(response.get("budget").toString())/1000000))));
            movie.setRevenue(Float.parseFloat(df.format(Float.parseFloat(response.get("revenue").toString())/1000000)));
            ids.put("TMDB_id", response.get("id").toString());
            ids.put("IMDB_id", response.get("imdb_id").toString());
            movie.setIds(ids);
            movie.setLanguage(response.get("original_language").toString());
            System.out.println(response);
            try {
                movie.setItPartOfASeries(!response.get("belongs_to_collection").toString().isEmpty());
            }
            catch(Exception e){
                movie.setItPartOfASeries(false);
            }

            List<HashMap<String, Object>> production_company = (List<HashMap<String, Object>>) response.get("production_companies");

            productionCompany.setName(production_company.get(0).get("name").toString());
            movie.setProductionCompany(productionCompany);
            movie.setDuration(Integer.parseInt(response.get("runtime").toString()));

            //movie.setDirector(director);
            movieDao.addMovieByObject(movie);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return Optional.of(movie);
    }

    public Optional<Non_Animated_Movie> getMovieById(String id)
    {
        return movieDao.getMovieById(id);
    }
}
