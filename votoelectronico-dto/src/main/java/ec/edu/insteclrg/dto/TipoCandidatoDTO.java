package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class TipoCandidatoDTO {

	private long id;

	private String name;
	
	private InstitucionDTO institucion; 
}
