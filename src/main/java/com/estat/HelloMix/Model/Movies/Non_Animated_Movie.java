package com.estat.HelloMix.Model.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
@Component
public class Non_Animated_Movie extends Movie {


    private boolean isItFromBook;
    private boolean isItPartOfASeries;

    @Autowired
    private List<Actor> actorsList;
    @Autowired
    private List<Actress> actressesList;

    public Non_Animated_Movie() {
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

    public boolean checkNull() throws IllegalAccessException
    {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) == null)
                return true;
        return false;
    }

}
