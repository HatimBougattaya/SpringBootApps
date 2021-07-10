package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Cinema;

public interface CinemaRepo extends JpaRepository<Cinema,Long> {

}
