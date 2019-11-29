package com.estat.HelloMix.Model.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Animation_Movie {
    private String title;
    private int duration;
    private String language;
    private String genre;
    private float budget;
    private float collections;
    private boolean multiLingual;


    private boolean isItFromManga;
    @Autowired
    private Director director;
    @Autowired
    private ProductionCompany productionCompany;
    @Autowired
    private Producer producer;
    @Autowired
    private List<Character> characters;

    @Override
    public String toString() {
        return "Animation_Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", budget=" + budget +
                ", collections=" + collections +
                ", multiLingual=" + multiLingual +
                ", isItFromManga=" + isItFromManga +
                ", director=" + director +
                ", productionCompany=" + productionCompany +
                ", producer=" + producer +
                ", characters=" + characters +
                '}';
    }

    public boolean isItFromManga() {
        return isItFromManga;
    }

    public void setItFromManga(boolean itFromManga) {
        isItFromManga = itFromManga;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getCollections() {
        return collections;
    }

    public void setCollections(float collections) {
        this.collections = collections;
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

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Animation_Movie() {

    }
}
