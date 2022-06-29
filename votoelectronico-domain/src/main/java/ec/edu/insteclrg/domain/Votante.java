package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.aspectj.weaver.tools.Trace;

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
	
	
	@Column(unique = true, nullable = false)
	private String cedula;
	
	@Column	
	private String name;
	
	@Column(name = "last_nme")
	private String lastName;
	
	@Column	
	private String email;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] photo;	
	
	@Column	
	private String phone;
	
	@Column	
	private String code;
	
	@Column
	private Boolean IsActive;
	
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	/*@ManyToOne
	@JoinColumn(name = "institucion_id")
	private Institucion institucion;*/

}
