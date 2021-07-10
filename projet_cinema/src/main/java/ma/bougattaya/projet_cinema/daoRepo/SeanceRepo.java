package ma.bougattaya.projet_cinema.daoRepo;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Seance;

public interface SeanceRepo extends JpaRepository<Seance,Long>{

}
