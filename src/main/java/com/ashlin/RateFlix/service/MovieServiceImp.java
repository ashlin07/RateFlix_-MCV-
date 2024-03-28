package com.ashlin.RateFlix.service;

import com.ashlin.RateFlix.Model.Movie;
import com.ashlin.RateFlix.Model.RatingRequest;
import com.ashlin.RateFlix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService{
    @Autowired
    private MovieRepository MovieRepository;
    @Override

    public void saveMovie(Movie movie){

        MovieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return MovieRepository.findAll();
    }
    @Override
    public void updateAverageRating(RatingRequest ratingRequest) {
        int movieId = ratingRequest.getMovieId();
        int newRating = ratingRequest.getNewRating();

        // Find the movie by ID or throw an exception if not found
        Movie movie = MovieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie with ID " + movieId + " not found"));

        // Get existing average rating and number of ratings
        double existingAverageRating = movie.getAverageRating();
        int numberOfRatings = movie.getNo_of_reviews();

        // Calculate new average rating
        double newAverageRating;
        if (numberOfRatings == 0) {
            newAverageRating = newRating; // If no ratings exist yet, set the new rating as the average
        } else {
            newAverageRating = ((existingAverageRating * numberOfRatings) + newRating) / (numberOfRatings + 1);
        }

        // Update movie entity
        movie.setAverageRating(newAverageRating);
        movie.setNo_of_reviews(numberOfRatings + 1);

        // Save updated movie entity
        MovieRepository.save(movie);
    }
}
