package ec.edu.insteclrg.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ProcesoEleccionDTO {

	private long id;
	
	private  LocalDateTime fechainicio;
	
	private LocalDateTime fechafinal;
	
	private Boolean activo;
	
	private String nombreproceso;
	
	private InstitucionDTO institucion;
}
