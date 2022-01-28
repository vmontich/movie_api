package com.vitormontich.movieapi.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vitormontich.movieapi.entities.WorstMovie;
import com.vitormontich.movieapi.models.Period;
import com.vitormontich.movieapi.repositories.WorstMovieRepository;
import com.vitormontich.movieapi.services.WorstMovieService;

@RestController
@RequestMapping(value = "/worst-movies")
public class WorstMovieResource {
	
	@Autowired
	private WorstMovieRepository repository;
	private WorstMovieService service = new WorstMovieService();
	
	@GetMapping
	public ResponseEntity<List<WorstMovie>> findAll() {
		List<WorstMovie> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		if(id == null) {
			return ResponseEntity.badRequest().build();
		}
		Optional<WorstMovie> optionalWorst = repository.findById(id);
		if(optionalWorst.equals(Optional.empty())) {
			return ResponseEntity.notFound().build();
		}
		WorstMovie worst = optionalWorst.get();
		return ResponseEntity.ok().body(worst);
		
	}
	
	@GetMapping(value = "/get-periods")
	public ResponseEntity<Map<String, List<Period>>> getMinAndMaxPeriods() {
		Map<String, List<Period>> minMaxPeriod = service.getMaxAndMinWinPeriods(repository);
		return ResponseEntity.ok().body(minMaxPeriod);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<?> save(@RequestBody WorstMovie worst) {
		WorstMovie wm = repository.save(worst);
		return ResponseEntity.created(null).body(wm);
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<?> update(@RequestBody WorstMovie worst) {
		if(worst.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		Optional<WorstMovie> optionalWorst = repository.findById(worst.getId());
		if(optionalWorst.equals(Optional.empty())) {
			return ResponseEntity.notFound().build();
		}
		WorstMovie wm = repository.save(worst);
		return ResponseEntity.ok().body(wm);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(id == null) {
			return ResponseEntity.badRequest().build();
		}
		Optional<WorstMovie> optionalWorst = repository.findById(id);
		if(optionalWorst.equals(Optional.empty())) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.ok().body(optionalWorst.get());
	}
}
