package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Salle;

public interface SalleRepo extends JpaRepository<Salle,Long> {

}
