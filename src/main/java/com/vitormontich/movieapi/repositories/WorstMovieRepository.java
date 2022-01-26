package com.vitormontich.movieapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vitormontich.movieapi.entities.WorstMovie;

@Repository
public interface WorstMovieRepository extends JpaRepository<WorstMovie, Long> {
	
}