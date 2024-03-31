import React,{useEffect, useState} from 'react';

import MovieDetails from './MovieDetails';

const MovieList = () => {

  const [movies,setMovies]=useState([]);
  useEffect(()=>{
    fetch("http://localhost:8080/movie/listMovies")
    .then(res=>res.json())
    .then((result)=>{
        setMovies(result)
    })
  },[]);
  

  return (
    <div>
      {movies.map((movie) => (
        <div key={movie.id}>
           
          <MovieDetails movie={movie} onSubmitReview={onSubmitReview} />
          <hr />
        </div>
      ))}
    </div>
  );
};
const onSubmitReview=(movieId, newRating) => {
    // Define the URL where the POST request is sent
    const url = "http://localhost:8080/movie/updateRating";
    
    // Format the data object with the movieId and newRating received as function arguments
    const data = {
        movieId: movieId,
        newRating: newRating
    };
    fetch(url, {
            method: 'POST', // Set the method to POST
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data) 
        }// Convert the JavaScript object to a JSON string
    );

}



export default MovieList;
