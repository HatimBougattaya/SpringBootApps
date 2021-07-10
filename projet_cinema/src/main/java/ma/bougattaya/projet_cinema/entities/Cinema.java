package ma.bougattaya.projet_cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Cinema implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude;
	private double latitude;
	private double altitude;
	private int nbrSalle;
	@ManyToOne
	private Ville ville;
	@OneToMany(mappedBy="cinema",fetch=FetchType.LAZY)
	private Collection<Salle> salles;
	
}
