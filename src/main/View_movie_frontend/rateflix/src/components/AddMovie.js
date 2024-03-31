import React, { useState } from 'react';
import { TextField, Button, Typography, Container, Box, Grid } from '@mui/material';

function AddMovie() {
    const [movieDetails, setMovieDetails] = useState({
        title: '',
        releaseYear: 0,
        genre: '',
        director: '',
        averageRating: 0,
        no_of_reviews: 0
    });

    const handleChange = (e) => {
        setMovieDetails({ ...movieDetails, [e.target.name]: e.target.value });
    };

    const handleAddMovie =  (e) => {
        e.preventDefault();
        
        console.log(movieDetails)
        console.log(JSON.stringify(movieDetails))
        fetch("http://localhost:8080/movie/add", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(movieDetails),
        });
        setMovieDetails({
            title: '',
            releaseYear: 0,
            genre: '',
            director: '',
            averageRating: 0,
            no_of_reviews: 0
        });
        
    };

    return (
        <Container component="main" maxWidth="xs">
            <Box
                sx={{
                    marginTop: 8,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}
            >
                <Typography component="h1" variant="h5">
                    Add a Movie
                </Typography>
                <Box component="form" noValidate sx={{ mt: 1 }}>
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        id="title"
                        label="Title"
                        name="title"
                        autoComplete="title"
                        autoFocus
                        value={movieDetails.title}
                        onChange={handleChange}
                    />
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        name="releaseYear"
                        label="Release Year"
                        type="number"
                        id="releaseYear"
                        autoComplete="current-releaseYear"
                        value={movieDetails.releaseYear}
                        onChange={handleChange}
                    />
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        name="genre"
                        label="Genre"
                        type="text"
                        id="genre"
                        autoComplete="genre"
                        value={movieDetails.genre}
                        onChange={handleChange}
                    />
                    <TextField
                        margin="normal"
                        required
                        fullWidth
                        name="director"
                        label="Director"
                        type="text"
                        id="director"
                        autoComplete="director"
                        value={movieDetails.director}
                        onChange={handleChange}
                    />
                    
                    <Button variant="contained" color="primary" onClick={handleAddMovie}>
          Add Movie
        </Button>
                </Box>
            </Box>
        </Container>
    );
}

export default AddMovie;
