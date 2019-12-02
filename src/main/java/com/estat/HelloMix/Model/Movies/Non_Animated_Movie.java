package com.estat.HelloMix.Model.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
@Component
public class Non_Animated_Movie {

    private String title;
    private Dictionary ids;
    private int duration;
    private String language;
    private String genre;
    private float budget;
    private float revenue;
    private float collections;
    private boolean multiLingual;
    private boolean isItFromBook;
    private boolean isItPartOfASeries;
    @Autowired
    private Director director;
    @Autowired
    private ProductionCompany productionCompany;
    @Autowired
    private Producer producer;

    @Autowired
    private List<Actor> actorsList;
    @Autowired
    private List<Actress> actressesList;

    @Override
    public String toString() {
        return "Non_Animated_Movie{" +
                "title='" + title + '\'' +
                ", ids=" + ids +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", collections=" + collections +
                ", multiLingual=" + multiLingual +
                ", isItFromBook=" + isItFromBook +
                ", isItPartOfASeries=" + isItPartOfASeries +
                ", director=" + director +
                ", productionCompany=" + productionCompany +
                ", producer=" + producer +
                ", actorsList=" + actorsList +
                ", actressesList=" + actressesList +
                '}';
    }

    public Non_Animated_Movie() {
    }

    public Non_Animated_Movie(String title, Dictionary ids, int duration, String language, String genre, float budget, float revenue, float collections, boolean multiLingual, boolean isItFromBook, boolean isItPartOfASeries) {
        this.title = title;
        this.ids = ids;
        this.duration = duration;
        this.language = language;
        this.genre = genre;
        this.budget = budget;
        this.revenue = revenue;
        this.collections = collections;
        this.multiLingual = multiLingual;
        this.isItFromBook = isItFromBook;
        this.isItPartOfASeries = isItPartOfASeries;
    }

    public Non_Animated_Movie(Non_Animated_Movie movie)
    {

    }
    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public boolean isItFromBook() {
        return isItFromBook;
    }

    public void setItFromBook(boolean itFromBook) {
        isItFromBook = itFromBook;
    }

    public boolean isItPartOfASeries() {
        return isItPartOfASeries;
    }

    public void setItPartOfASeries(boolean itPartOfASeries) {
        isItPartOfASeries = itPartOfASeries;
    }


    public Dictionary getIds() {
        return ids;
    }

    public void setIds(Dictionary ids) {
        this.ids = ids;
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

    public List<Actor> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    public List<Actress> getActressesList() {
        return actressesList;
    }

    public void setActressesList(List<Actress> actressesList) {
        this.actressesList = actressesList;
    }
}
