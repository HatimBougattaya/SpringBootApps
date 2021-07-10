package ma.bougattaya.projet_cinema.daoRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.bougattaya.projet_cinema.entities.Categorie;


public interface CategorieRepo extends JpaRepository<Categorie,Long>{

}
