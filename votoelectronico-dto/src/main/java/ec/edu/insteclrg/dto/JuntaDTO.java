package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class JuntaDTO {
    
	private long id;
	
	private String number;	
		
	private String president;
	
	private String vicePresident;
	
	private String secretary;
	
	private RecintoDTO recinto;
}
