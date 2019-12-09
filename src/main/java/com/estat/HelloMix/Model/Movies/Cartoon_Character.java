package com.estat.HelloMix.Model.Movies;

import org.springframework.stereotype.Component;

@Component
public class Cartoon_Character {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
