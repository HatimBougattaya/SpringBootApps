package ma.bougattaya.projet_cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Salle implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nbrPlace;
	@ManyToOne
	private Cinema cinema;
	@OneToMany(mappedBy="salle")
	private Collection<Place> places;
	@OneToMany(mappedBy="salle",fetch=FetchType.LAZY)
	private Collection<Projection> projections;
}
