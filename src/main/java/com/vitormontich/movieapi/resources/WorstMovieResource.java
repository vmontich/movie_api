package com.vitormontich.movieapi.resources;

import java.util.List;
import java.util.Map;

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
		System.out.println("Método findAll");
		List<WorstMovie> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorstMovie> find(@PathVariable Long id) {
		System.out.println("Método find");
		WorstMovie worst = repository.findById(id).get();
		return ResponseEntity.ok().body(worst);
	}
	
	@GetMapping(value = "/get-periods")
	public ResponseEntity<Map<String, List<Period>>> getMinAndMaxPeriods() {
		Map<String, List<Period>> minMaxPeriod = service.getMaxAndMinWinPeriods(repository);
		return ResponseEntity.ok().body(minMaxPeriod);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<WorstMovie> save(@RequestBody WorstMovie worst) {
		System.out.println("Método Save");
		WorstMovie wm = repository.save(worst);
		return ResponseEntity.ok().body(wm);
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<WorstMovie> update(@RequestBody WorstMovie worst) {
		System.out.println("Método Update");
		WorstMovie wm = repository.save(worst);
		return ResponseEntity.ok().body(wm);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		System.out.println("Método Delete");
		repository.deleteById(id);
	}
}
