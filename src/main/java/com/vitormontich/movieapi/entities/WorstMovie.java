package com.vitormontich.movieapi.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorstMovie implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer year;
	private String movie;
	private String studios;
	private String producers;
	private boolean winner;
	
	public WorstMovie() {  }

	public WorstMovie(Long id, Integer year, String movie, String studios, String producers, boolean winner) {
		super();
		this.id = id;
		this.year = year;
		this.movie = movie;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getStudios() {
		return studios;
	}

	public void setStudios(String studios) {
		this.studios = studios;
	}

	public String getProducers() {
		return producers;
	}

	public void setProducers(String producers) {
		this.producers = producers;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorstMovie other = (WorstMovie) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
