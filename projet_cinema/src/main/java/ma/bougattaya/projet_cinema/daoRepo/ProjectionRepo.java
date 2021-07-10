package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Projection;

public interface ProjectionRepo extends JpaRepository<Projection,Long>{

}
