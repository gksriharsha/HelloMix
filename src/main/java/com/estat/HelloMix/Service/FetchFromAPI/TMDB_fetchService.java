package com.estat.HelloMix.Service.FetchFromAPI;

import com.estat.HelloMix.Model.Movies.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.*;
//@Component("TMDB")
public class TMDB_fetchService implements fetchService {
    @Value("${API.KEY}")
    private String key;
    private static DecimalFormat df = new DecimalFormat("0.00");
    @Override
    public Optional<Movie> fetchMovieById(String id)
    {
        Movie movie = new Movie();
        String uri = "https://api.themoviedb.org/3/movie/{movie_id}?api_key="+key+"&language=en-US";
        String get_uri ="";
        List<String> genres = new ArrayList<>();
        Dictionary<String,String> ids = new Hashtable<>();
        ProductionCompany productionCompany = new ProductionCompany();
        Director director = new Director();
        get_uri = uri.replace("{movie_id}",id);
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String result = restTemplate.getForObject(get_uri, String.class);
            HashMap<String, Object> response = (HashMap<String, Object>) new ObjectMapper().readValue(result, HashMap.class);
            System.out.println(response);
            if((response.containsKey("status_code") && response.get("status_code").equals("34")))
                return Optional.empty();

            for(HashMap<String,Object > temp:(List<HashMap<String, Object>>)response.get("genres"))
            {
                genres.add(temp.get("name").toString());
            }
            //movie.setGenre(genres);
            if(genres.contains("animation") || genres.contains("Animation"))
            {
                movie = new Animation_Movie();
                fetchAnimationById((Animation_Movie)movie,response);
            }
            else
            {
                movie = new Non_Animated_Movie();
                movie = fetchNonAnimationById((Non_Animated_Movie) movie, response);
            }
            movie.setGenre(genres);
            movie.setTitle(response.get("original_title").toString());
            movie.setBudget(Float.parseFloat(df.format((Float.parseFloat(response.get("budget").toString())/1000000))));
            movie.setRevenue(Float.parseFloat(df.format(Float.parseFloat(response.get("revenue").toString())/1000000)));
            ids.put("TMDB_id", response.get("id").toString());
            ids.put("IMDB_id", response.get("imdb_id").toString());
            movie.setIds(ids);
            movie.setLanguage(response.get("original_language").toString());


            List<HashMap<String, Object>> production_company = (List<HashMap<String, Object>>) response.get("production_companies");

            productionCompany.setName(production_company.get(0).get("name").toString());
            movie.setProductionCompany(productionCompany);
            movie.setDuration(Integer.parseInt(response.get("runtime").toString()));

        }
        catch(HttpClientErrorException exception)
        {
            if(exception.getMessage().contains("404"))
                return Optional.empty();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //System.out.println("This is "+);
        }
        return Optional.of(movie);
    }



    private Animation_Movie fetchAnimationById(Animation_Movie movie,  HashMap<String, Object> response)
    {
        List<Cartoon_Character> chars = new ArrayList<>();
        Cartoon_Character chara = new Cartoon_Character();
        chara.setName("Hellen");
        chars.add(chara);
        movie.setCharacters(chars);
        movie.setItFromManga(false);
        return movie;
    }
    private Non_Animated_Movie fetchNonAnimationById(Non_Animated_Movie movie, HashMap<String, Object> response)
    {
        try{
            movie.setItPartOfASeries(!response.get("belongs_to_collection").toString().isEmpty());
        }
        catch(Exception e){
            movie.setItPartOfASeries(false);
        }
        return movie;
    }
}
