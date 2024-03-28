package com.ashlin.RateFlix.controller;

import com.ashlin.RateFlix.Model.Movie;
import com.ashlin.RateFlix.Model.RatingRequest;
import com.ashlin.RateFlix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/updateRating")
    public ResponseEntity<String> updateRating(@RequestBody RatingRequest ratingRequest) {
        try {
            System.out.println("Received movie ID: " + ratingRequest.getMovieId());
            System.out.println("Received new rating: " + ratingRequest.getNewRating());

            // Call the service method to update the average rating
            MovieService.updateAverageRating(ratingRequest);

            // Return a success response
            return ResponseEntity.ok("Rating updated successfully");
        } catch (RuntimeException e) {
            // Log the exception
            System.out.println("Error updating rating: " + e.getMessage());

            // Return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update rating");
        }
    }
}
