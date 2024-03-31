import React, { useState } from 'react';
import { Box, Typography, Rating, Button, Divider } from '@mui/material';

const MovieDetails = ({ movie, onSubmitReview }) => {
  const [rating, setRating] = useState(movie["averageRating"]); // Default rating value

  const handleRatingChange = (event, newValue) => {
    setRating(newValue);
  };

  const handleSubmitReview = () => {
    // Call the onSubmitReview function with the selected rating and movie ID
    onSubmitReview(movie.id, rating);
  };

  return (
    <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 2 }}>
      <Box>
        <Typography variant="h5">{movie.title}</Typography>
        <Typography variant="subtitle1">Release Year: {movie.releaseYear}</Typography>
        <Typography variant="body1">Genre: {movie.genre}</Typography>
        <Typography variant="body1">Director: {movie.director}</Typography>
      </Box>
      <Box>
        <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
          <Typography variant="body1">Your Rating:</Typography>
          <Rating
            name="movie-rating"
            value={rating}
            precision={1}
            onChange={handleRatingChange}
          />
        </Box>
        <Button variant="contained" color="primary" onClick={handleSubmitReview}>
          Submit Review
        </Button>
      </Box>
    </Box>
  );
};

export default MovieDetails;