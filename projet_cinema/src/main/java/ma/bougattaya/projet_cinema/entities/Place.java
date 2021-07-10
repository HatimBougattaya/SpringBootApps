package ma.bougattaya.projet_cinema.entities;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Place implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double longitude;
	private double latitude;
	private double altitude;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy = "place",fetch=FetchType.LAZY)
	private Collection<Ticket> tickets;
}
