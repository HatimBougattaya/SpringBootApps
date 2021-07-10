package ma.enset.tpjpa.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="PATIENTS")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		@Column(name="name",length=25)
		@NotNull
		@Size(min=3 , max=15)
	private String name;
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date dateNaissance;
	private boolean malade;
	//@DecimalMin "
}
