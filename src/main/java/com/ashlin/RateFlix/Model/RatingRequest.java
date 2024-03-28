package com.ashlin.RateFlix.Model;




public class RatingRequest {
    private int movieId;
    private int newRating;

    public RatingRequest(){

    }
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getNewRating() {
        return newRating;
    }

    public void setNewRating(int newRating) {
        this.newRating = newRating;
    }
}
