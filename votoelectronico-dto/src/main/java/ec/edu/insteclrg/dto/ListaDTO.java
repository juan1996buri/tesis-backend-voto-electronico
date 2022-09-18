package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ListaDTO {

	private long id;

	private String logo;

	private String nombre;

	private ProcesoEleccionDTO procesoEleccion;
}
