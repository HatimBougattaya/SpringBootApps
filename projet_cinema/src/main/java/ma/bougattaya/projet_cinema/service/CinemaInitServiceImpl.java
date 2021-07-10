package ma.bougattaya.projet_cinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.bougattaya.projet_cinema.daoRepo.*;
import ma.bougattaya.projet_cinema.entities.*;

@Transactional
@Service
public class CinemaInitServiceImpl implements ICinemaInitService {
	@Autowired
	private VilleRepo villeR;
	@Autowired
	private CinemaRepo cinemaR;
	@Autowired
	private SalleRepo salleR;
	@Autowired
	private PlaceRepository placeR;
	@Autowired
	private FilmRepo filmR;
	@Autowired
	private SeanceRepo seanceR;
	@Autowired
	private CategorieRepo categorieR;
	@Autowired
	private ProjectionRepo projectionR;
	@Autowired 
	private TicketRepository ticketR;
	
	@Override
	public void initVilles() {
		Stream.of("Casablanca","Rabat","Tanger","Marakech").forEach(vn ->{
			Ville v = new Ville();
			v.setName(vn);
			villeR.save(v);
		} );
		
	}

	@Override
	public void initCinemas() {
		villeR.findAll().forEach(v->{
			Stream.of("Megarama","Rif","Tarik","Imax").forEach(nc->{
				Cinema c = new Cinema();
				c.setName(nc);
				c.setVille(v);
				c.setNbrSalle(4 + (int)(Math.random()*7));
				cinemaR.save(c);
			});
		});
	}

	@Override
	public void initSalles() {
		cinemaR.findAll().forEach(cinema->{
			Salle s = new Salle();
			s.setCinema(cinema);
			s.setName("salleee");
			s.setNbrPlace(10 +(int)(Math.random()*50));
			salleR.save(s);
			});
	}

	@Override
	public void initPlaces() {
		salleR.findAll().forEach(salle->{
			for (int i = 0;i<salle.getNbrPlace();i++) {
				Place p = new Place();
				p.setNumero(i);
				p.setSalle(salle);
				placeR.save(p);
			}
		});
		
	}

	@Override
	public void films() {
		List<Categorie> lc = categorieR.findAll();
		Stream.of("The Godfather","Mad men","Billions","Sopranos","Godfellas","A Bronx Tale","The Wire").forEach(fn->{
			Film f = new Film();
			f.setTitre(fn);
			f.setCategorie(lc.get((int)(Math.random()*lc.size())));
			filmR.save(f);
		});
		
	}

	@Override
	public void projections() {
		villeR.findAll().forEach(a->{
			a.getCinemas().forEach(b->{
				b.getSalles().forEach(s->{
					filmR.findAll().forEach(film->{
						seanceR.findAll().forEach(seance->{
							Projection p = new Projection();
							p.setFilm(film);
							p.setSalle(s);
							p.setSeance(seance);
							p.setPrix((int)(Math.random()*110)+50);
							p.setDate(new Date());
						});
					});
				});
			});
		});
		
	}

	@Override
	public void initTickets() {
		projectionR.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(place->{
				Ticket t = new Ticket();
				t.setPlace(place);
				t.setProjection(p);
				t.setReserve(false);
				t.setPrix(p.getPrix());
				ticketR.save(t);
			});
		});
	}

	@Override
	public void initCategories() {
		Stream.of("Action","Drama","Western","Comedy","History").forEach(cn->{
			Categorie c = new Categorie();
			c.setName(cn);
			categorieR.save(c);
		});
		
	}

	@Override
	public void initSeances() {
		DateFormat dateF = new SimpleDateFormat("HH:mm") ;
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(time->{
			Seance s= new Seance();
			//try catch maybe needed with ParseExeption from java.text
			try {
				s.setHeureDebut(dateF.parse(time));
				seanceR.save(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		});
		
	}

}
