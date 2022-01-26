package com.vitormontich.movieapi.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vitormontich.movieapi.entities.WorstMovie;
import com.vitormontich.movieapi.repositories.WorstMovieRepository;

@RestController
@RequestMapping(value = "/worstmovies")
public class WorstMovieResource {
	
	@Autowired
	private WorstMovieRepository worstMovieRepository;
	
	@GetMapping
	public ResponseEntity<List<WorstMovie>> findAll() {
		List<WorstMovie> list = worstMovieRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorstMovie> findById(@PathVariable Long id) {
		WorstMovie worst = worstMovieRepository.findById(id).get();
		return ResponseEntity.ok().body(worst);
	}
}
