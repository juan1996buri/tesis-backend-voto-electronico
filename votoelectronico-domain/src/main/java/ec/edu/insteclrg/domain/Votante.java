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
public class Votante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;	
	
	@Column(unique = true,nullable = false)
	private String cedula;
	
	@Column(nullable = false)	
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;
	
	@Column	
	private String correo;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] imagen;	
	
	@Column	
	private String celular;
	
	@Column	
	private String codigo;
	
	@Column
	private Boolean activo;
	
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	@ManyToOne
	@JoinColumn(name = "institucion_id")
	private Institucion institucion;
	
	@ManyToOne
	@JoinColumn(name = "sexo_id")
	private Sexo sexo;
}
