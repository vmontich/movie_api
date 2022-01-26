package com.vitormontich.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		
		// id, year, title, studios, producers, winner
		
		WorstMovie wm1 = new WorstMovie(1L, 1995, "Filme 001", "Estúdio 001", "Produtor001", true);
		WorstMovie wm2 = new WorstMovie(2L, 1995, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm3 = new WorstMovie(3L, 1995, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm4 = new WorstMovie(4L, 1995, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm5 = new WorstMovie(5L, 1995, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm6 = new WorstMovie(6L, 1996, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm7 = new WorstMovie(7L, 1996, "Filme 002", "Estúdio 002", "Produtor002", true);
		WorstMovie wm8 = new WorstMovie(8L, 1996, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm9 = new WorstMovie(9L, 1996, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm10 = new WorstMovie(10L, 1996, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm11 = new WorstMovie(11L, 1997, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm12 = new WorstMovie(12L, 1997, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm13 = new WorstMovie(13L, 1997, "Filme 003", "Estúdio 003", "Produtor003", true);
		WorstMovie wm14 = new WorstMovie(14L, 1997, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm15 = new WorstMovie(15L, 1997, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm16 = new WorstMovie(16L, 1998, "Filme 001", "Estúdio 001", "Produtor001", true);
		WorstMovie wm17 = new WorstMovie(17L, 1998, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm18 = new WorstMovie(18L, 1998, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm19 = new WorstMovie(19L, 1998, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm20 = new WorstMovie(20L, 1998, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm21 = new WorstMovie(21L, 1999, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm22 = new WorstMovie(22L, 1999, "Filme 002", "Estúdio 002", "Produtor002", true);
		WorstMovie wm23 = new WorstMovie(23L, 1999, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm24 = new WorstMovie(24L, 1999, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm25 = new WorstMovie(25L, 1999, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm26 = new WorstMovie(26L, 2000, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm27 = new WorstMovie(27L, 2000, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm28 = new WorstMovie(28L, 2000, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm29 = new WorstMovie(29L, 2000, "Filme 004", "Estúdio 004", "Produtor004", true);
		WorstMovie wm30 = new WorstMovie(30L, 2000, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm31 = new WorstMovie(31L, 2001, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm32 = new WorstMovie(32L, 2001, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm33 = new WorstMovie(33L, 2001, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm34 = new WorstMovie(34L, 2001, "Filme 004", "Estúdio 004", "Produtor004", true);
		WorstMovie wm35 = new WorstMovie(35L, 2001, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		WorstMovie wm36 = new WorstMovie(36L, 2002, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm37 = new WorstMovie(37L, 2002, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm38 = new WorstMovie(38L, 2002, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm39 = new WorstMovie(39L, 2002, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm40 = new WorstMovie(40L, 2002, "Filme 005", "Estúdio 005", "Produtor005", true);
		
		WorstMovie wm41 = new WorstMovie(41L, 2003, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm42 = new WorstMovie(42L, 2003, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm43 = new WorstMovie(43L, 2003, "Filme 003", "Estúdio 003", "Produtor003", false);
		WorstMovie wm44 = new WorstMovie(44L, 2003, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm45 = new WorstMovie(45L, 2003, "Filme 005", "Estúdio 005", "Produtor005", true);
		
		WorstMovie wm46 = new WorstMovie(46L, 2004, "Filme 001", "Estúdio 001", "Produtor001", false);
		WorstMovie wm47 = new WorstMovie(47L, 2004, "Filme 002", "Estúdio 002", "Produtor002", false);
		WorstMovie wm48 = new WorstMovie(48L, 2004, "Filme 003", "Estúdio 003", "Produtor003", true);
		WorstMovie wm49 = new WorstMovie(49L, 2004, "Filme 004", "Estúdio 004", "Produtor004", false);
		WorstMovie wm50 = new WorstMovie(50L, 2004, "Filme 005", "Estúdio 005", "Produtor005", false);
		
		worstMovieRepository.save(wm1);
		worstMovieRepository.save(wm2);
		worstMovieRepository.save(wm3);
		worstMovieRepository.save(wm4);
		worstMovieRepository.save(wm5);
		worstMovieRepository.save(wm6);
		worstMovieRepository.save(wm7);
		worstMovieRepository.save(wm8);
		worstMovieRepository.save(wm9);
		worstMovieRepository.save(wm10);
		worstMovieRepository.save(wm11);
		worstMovieRepository.save(wm12);
		worstMovieRepository.save(wm13);
		worstMovieRepository.save(wm14);
		worstMovieRepository.save(wm15);
		worstMovieRepository.save(wm16);
		worstMovieRepository.save(wm17);
		worstMovieRepository.save(wm18);
		worstMovieRepository.save(wm19);
		worstMovieRepository.save(wm20);
		worstMovieRepository.save(wm21);
		worstMovieRepository.save(wm22);
		worstMovieRepository.save(wm23);
		worstMovieRepository.save(wm24);
		worstMovieRepository.save(wm25);
		worstMovieRepository.save(wm26);
		worstMovieRepository.save(wm27);
		worstMovieRepository.save(wm28);
		worstMovieRepository.save(wm29);
		worstMovieRepository.save(wm30);
		worstMovieRepository.save(wm31);
		worstMovieRepository.save(wm32);
		worstMovieRepository.save(wm33);
		worstMovieRepository.save(wm34);
		worstMovieRepository.save(wm35);
		worstMovieRepository.save(wm36);
		worstMovieRepository.save(wm37);
		worstMovieRepository.save(wm38);
		worstMovieRepository.save(wm39);
		worstMovieRepository.save(wm40);
		worstMovieRepository.save(wm41);
		worstMovieRepository.save(wm42);
		worstMovieRepository.save(wm43);
		worstMovieRepository.save(wm44);
		worstMovieRepository.save(wm45);
		worstMovieRepository.save(wm46);
		worstMovieRepository.save(wm47);
		worstMovieRepository.save(wm48);
		worstMovieRepository.save(wm49);
		worstMovieRepository.save(wm50);
	}

}