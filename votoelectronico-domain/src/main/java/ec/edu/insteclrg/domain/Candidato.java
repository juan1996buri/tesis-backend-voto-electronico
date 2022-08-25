package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;	
	
	@ManyToOne
	@JoinColumn(name = "votante_id")
	private Votante votante;
	
	@ManyToOne
	@JoinColumn(name = "tipo_candidato_id")
	private TipoCandidato tipoCandidato;
	
	@ManyToOne
	@JoinColumn(name = "lista_id")
	private Lista lista;
	
	@ManyToOne
	@JoinColumn(name = "proceso_eleccion_id")
	private ProcesoEleccion procesoEleccion;
	
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] imagen;	
}

