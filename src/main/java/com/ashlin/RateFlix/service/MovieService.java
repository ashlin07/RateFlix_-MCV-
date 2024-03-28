package com.ashlin.RateFlix.service;

import com.ashlin.RateFlix.Model.Movie;
import com.ashlin.RateFlix.Model.RatingRequest;

import java.util.List;

public interface MovieService {
    public void saveMovie(Movie Movie );
    public List<Movie> getMovies();
    public void updateAverageRating(RatingRequest ratingRequest);
}
