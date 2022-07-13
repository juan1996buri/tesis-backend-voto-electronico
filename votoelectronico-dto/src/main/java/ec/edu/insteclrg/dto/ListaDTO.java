package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ListaDTO {

	private long id;

	private byte[] logo;

	private String nombre;

	private Boolean activo;

	private ProcesoEleccionDTO procesoeleccion;
}
