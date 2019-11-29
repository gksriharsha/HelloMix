package com.estat.HelloMix.Model.Movies;

import com.estat.HelloMix.Model.Person;
import org.springframework.stereotype.Component;

@Component
public class Actress implements Person {

    private String name;
    private int age;
}
