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
public class Institucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column
	private String correo;
	
	@Column
	private byte[] logo;

	@Column
	private String nombre;

	@ManyToOne
	@JoinColumn()
	private Ciudad ciudad;

	@Column
	private String direccion;

	@Column
	private String telefono;

	@Column(nullable = false, unique = true)
	private String ruc;

	@ManyToOne
	@JoinColumn()
	private TipoInstitucion tipoinstitucion;

	@Column
	private Boolean activo;
}
