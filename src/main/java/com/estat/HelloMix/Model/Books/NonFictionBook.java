package com.estat.HelloMix.Model.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class NonFictionBook {
    private String title;
    @Autowired
    private PublishingHouse publishingHouse;
    private List<String> awards;
    @Autowired
    private Author author;
    private String genre;
    private int pages;
    private int words;

    @Override
    public String toString() {
        return "NonFictionBook{" +
                "title='" + title + '\'' +
                ", publishingHouse=" + publishingHouse +
                ", awards=" + awards +
                ", author=" + author +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", words=" + words +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public NonFictionBook() {
    }
}
