package com.estat.HelloMix.Model.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component("Animated")
public class Animation_Movie extends Movie {

    private boolean isItFromManga;
    @Autowired
    private List<Cartoon_Character> characters;

    public Animation_Movie() {

    }

    public boolean isItFromManga() {
        return isItFromManga;
    }

    public void setItFromManga(boolean itFromManga) {
        isItFromManga = itFromManga;
    }

    public List<Cartoon_Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Cartoon_Character> characters) {
        this.characters = characters;
    }
    public boolean checkNull() throws IllegalAccessException
    {
        for (Field f : getClass().getDeclaredFields())
            if (f.get(this) == null)
                return true;
        return false;
    }
}
