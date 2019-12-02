package com.estat.HelloMix.Model.Movies;

import org.springframework.stereotype.Component;

@Component
public class ProductionCompany {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
