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

	@Column(nullable = false, unique = false)
	private String coreo;

	@Column
	private String contraseña;

	@Column
	private String nombre;

	@ManyToOne
	@JoinColumn()
	private Ciudad ciudad;

	@Column
	private String direccion;

	@Column
	private String telefono;

	@Column(unique = true)
	private String ruc;

	@ManyToOne
	@JoinColumn()
	private TipoInstitucion tipoinstitucion;

	@Column
	private Boolean esActivo;
}
