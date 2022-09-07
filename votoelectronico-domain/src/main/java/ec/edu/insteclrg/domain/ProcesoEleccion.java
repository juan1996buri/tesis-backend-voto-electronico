package ec.edu.insteclrg.domain;

import java.time.LocalDateTime;
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
public class ProcesoEleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = true)
	private LocalDateTime fechainicio;	
	
	@Column(nullable = true)
	private LocalDateTime fechafinal;

	@Column
	private Boolean activo;

	@Column(nullable = false)
	private String nombreproceso;

	@ManyToOne()
	@JoinColumn(name = "institucion_id")
	private Institucion institucion;
}
