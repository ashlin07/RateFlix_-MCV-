package com.ashlin.RateFlix.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private String director;
    private double averageRating;
    private int no_of_reviews;

// Constructors, getters, and setters


    public Movie() {
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getNo_of_reviews() {
        return no_of_reviews;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setNo_of_reviews(int no_of_reviews) {
        this.no_of_reviews = no_of_reviews;
    }
}