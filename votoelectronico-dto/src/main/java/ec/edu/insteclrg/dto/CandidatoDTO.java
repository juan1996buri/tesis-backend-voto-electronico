package ec.edu.insteclrg.dto;


import lombok.Data;

@Data
public class CandidatoDTO {
	
	private long id;		

	private String  nombre;

	private TipoCandidatoDTO tipoCandidato;	
	
	private ListaDTO lista;
		
	private String imagen;	
}
