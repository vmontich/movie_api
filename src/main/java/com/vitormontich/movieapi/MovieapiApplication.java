package com.vitormontich.movieapi;

import java.io.FileReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.vitormontich.movieapi.entities.WorstMovie;
import com.vitormontich.movieapi.repositories.WorstMovieRepository;

@SpringBootApplication
public class MovieapiApplication implements CommandLineRunner {
	
	@Autowired
	private WorstMovieRepository worstMovieRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovieapiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
		try(CSVReader reader = new CSVReaderBuilder(new FileReader("movielist.csv"))
			.withCSVParser(csvParser)
			.withSkipLines(1)
			.build()) {
			List<String[]> r = reader.readAll();
			
			for(String[] item : r) {
				boolean winner = item[4].equalsIgnoreCase("yes") ? true: false;
				WorstMovie wm = new WorstMovie(null, Integer.parseInt(item[0]), item[1], item[2], item[3], winner);
				worstMovieRepository.save(wm);
			}
		}
	}

}