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
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "junta_id")
	private Lista lista;
	
	@ManyToOne
	@JoinColumn(name = "votante_id")
	private Votante votante;
	
	@ManyToOne
	@JoinColumn(name = "procesoeleccion_id")
	private ProcesoEleccion procesoEleccion;
	
	private LocalDateTime fechaRegistro;
}
