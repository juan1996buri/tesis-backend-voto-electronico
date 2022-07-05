package ec.edu.insteclrg.dto;


import lombok.Data;

@Data
public class RecintoDTO {
    
	private long id;
	
	private String name;
	
	private String direction;

	private String phone;
	
	private CiudadDTO ciudad;
	
	private InstitucionDTO institucion;
}
