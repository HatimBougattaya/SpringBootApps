package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Film;

public interface FilmRepo extends JpaRepository<Film,Long>{

}
