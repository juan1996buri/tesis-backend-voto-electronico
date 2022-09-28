package ec.edu.insteclrg.domain;

import lombok.Data;

@Data
public class CambiarPassword {
	
	private String ruc;
	
	private String antiguoPassword;
	
	private String nuevoPassword;	
}
