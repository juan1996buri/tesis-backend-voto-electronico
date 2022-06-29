package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Junta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String number;	
		
	@Column
	private String president;
	
	@Column
	private String vicePresident;
	
	@Column
	private String secretary;
	
	@ManyToOne
	@JoinColumn(name = "recinto_id")
	private Recinto recinto;

}
