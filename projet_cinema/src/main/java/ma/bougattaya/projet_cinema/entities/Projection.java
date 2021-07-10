package ma.bougattaya.projet_cinema.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Projection implements Serializable {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double prix;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date date;
	@ManyToOne
	private Film film;
	@ManyToOne
	private Salle salle;
	@ManyToOne
	private Seance seance;
	@OneToMany(mappedBy="projection",fetch=FetchType.LAZY)
	private Collection<Ticket> tickets;
	

}
