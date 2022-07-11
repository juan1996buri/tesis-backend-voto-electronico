package ec.edu.insteclrg.dto;


import lombok.Data;

@Data
public class RecintoDTO {
    
	private long id;
	
	private String nombre;
	
	private String direccion;

	private String celular;
	
	private CiudadDTO ciudad;
	
	private InstitucionDTO institucion;
}
