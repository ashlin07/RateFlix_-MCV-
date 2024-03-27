package com.ashlin.RateFlix.controller;

import com.ashlin.RateFlix.Model.Movie;
import com.ashlin.RateFlix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService MovieService;

    @PostMapping("/add")
    public String add(@RequestBody Movie movie){
        MovieService.saveMovie(movie);
        return "new movie added";
    }
    @GetMapping("/listMovies")
    public List<Movie> getMovies(){
        return MovieService.getMovies();

    }
}
