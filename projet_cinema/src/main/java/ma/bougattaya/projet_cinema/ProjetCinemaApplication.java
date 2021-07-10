package ma.bougattaya.projet_cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.bougattaya.projet_cinema.service.ICinemaInitService;

@SpringBootApplication
public class ProjetCinemaApplication implements CommandLineRunner { 
	@Autowired
	private ICinemaInitService initS;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initS.initVilles();
		initS.initCinemas();
		initS.initSalles();
		initS.initPlaces();
		initS.initSeances();
		initS.initCategories();
		initS.films();
		initS.projections();
		initS.initTickets();
	}

}
