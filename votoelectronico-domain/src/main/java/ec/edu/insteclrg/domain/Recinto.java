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
public class Recinto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
<<<<<<< HEAD
	@Column
	private String name;
=======
	@Column(nullable = false)
	private String nombre;
>>>>>>> refs/remotes/origin/developer
	
<<<<<<< HEAD
	@Column	
	private String direction;
=======
	@Column(nullable = false)
	private String direccion;
>>>>>>> refs/remotes/origin/developer

	@Column	
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "ciudad_id")
	private Ciudad ciudad;
	
	
	@ManyToOne
	@JoinColumn(name = "institucion_id")
	private Institucion Institucion;
}
