package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Recinto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column
	private String name;
	
	@Column	
	private String direction;

	@Column	
	private String phone;
	
	/*@ManyToOne
	@JoinColumn(name = "ciudad_id")
	private Ciudad ciudad;
	
	@ManyToOne
	@JoinColumn(name = "ciudad_id")
	private Institucion institu;*/

}
