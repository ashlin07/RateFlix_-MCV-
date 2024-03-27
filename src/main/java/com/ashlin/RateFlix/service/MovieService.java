package com.ashlin.RateFlix.service;

import com.ashlin.RateFlix.Model.Movie;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie Movie );
    public List<Movie> getMovies();



}
