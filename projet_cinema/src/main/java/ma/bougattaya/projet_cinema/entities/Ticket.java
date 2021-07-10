package ma.bougattaya.projet_cinema.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Ticket implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomClient;
	private double prix;
	//Very nice strategy in this case
	@Column(unique=true,nullable=true)
	private Integer codePayement;
	private boolean reserve;
	@ManyToOne 
	private Projection projection;
	@ManyToOne 
	private Place place;
}
