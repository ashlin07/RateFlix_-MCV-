package com.ashlin.RateFlix.service;

import com.ashlin.RateFlix.Model.Movie;
import com.ashlin.RateFlix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService{
    @Autowired
    private MovieRepository MovieRepository;
    @Override

    public Movie saveMovie(Movie movie){
        return MovieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return MovieRepository.findAll();
    }
}
