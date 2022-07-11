package ec.edu.insteclrg.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VotoDTO {
	
	private long id;
	
	private ListaDTO lista;
	
	private VotanteDTO votante;
	
	private ProcesoEleccionDTO procesoEleccion;
	
	private LocalDateTime fechaRegistro;
}
