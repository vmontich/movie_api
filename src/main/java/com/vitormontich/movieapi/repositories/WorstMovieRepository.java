package com.vitormontich.movieapi.repositories;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Component;
import com.vitormontich.movieapi.entities.WorstMovie;

@Component
public class WorstMovieRepository {
	
	private Map<Long, WorstMovie> map = new HashMap<>();
	
	public void save(WorstMovie object) {
		map.put(object.getId(), object);
	}
	
	public WorstMovie findById(Long id) {
		return map.get(id);
	}
	
	public List<WorstMovie> findAll() {
		return new ArrayList<WorstMovie>(map.values());
	}
}
