package ma.bougattaya.projet_cinema.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor@Data
public class Categorie implements Serializable{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 75)
	private String name;
	@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Film> films;
}
