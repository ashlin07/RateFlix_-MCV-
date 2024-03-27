package com.ashlin.RateFlix.repository;

import com.ashlin.RateFlix.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie,Integer>{

}
