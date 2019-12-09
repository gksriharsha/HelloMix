package com.estat.HelloMix.Model.Movies;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.List;

public class Movie {
    private String title;
    private Dictionary ids;
    private int duration;
    private String language;
    private List<String> genre;
    private float budget;
    private float revenue;
    private boolean multiLingual;

    @Autowired
    private Director director;
    @Autowired
    private ProductionCompany productionCompany;
    @Autowired
    private Producer producer;

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Dictionary getIds() {
        return ids;
    }

    public void setIds(Dictionary ids) {
        this.ids = ids;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public boolean isMultiLingual() {
        return multiLingual;
    }

    public void setMultiLingual(boolean multiLingual) {
        this.multiLingual = multiLingual;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
    public boolean checkNull() throws IllegalAccessException
    {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) == null)
                return true;
        return false;
    }
}
