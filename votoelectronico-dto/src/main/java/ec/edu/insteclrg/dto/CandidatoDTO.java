package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class CandidatoDTO {
	
	private long id;	
	
	private VotanteDTO votante;	

	private TipoCandidatoDTO tipoCandidato;	
	
	private ListaDTO lista;
	
	private ProcesoEleccionDTO procesoEleccion;
		
	private byte[] imagen;	
}
