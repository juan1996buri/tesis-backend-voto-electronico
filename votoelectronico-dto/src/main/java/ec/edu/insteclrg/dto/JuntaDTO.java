package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class JuntaDTO {
    
	private long id;
	
	private String numero;	
		
	private String presidente;
	
	private String vicePresidente;
	
	private String secretario;
	
	private RecintoDTO recinto;
}
