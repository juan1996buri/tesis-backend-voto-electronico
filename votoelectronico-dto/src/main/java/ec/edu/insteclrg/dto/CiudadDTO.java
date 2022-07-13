package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class CiudadDTO {

	private long id;

	private String nombre;

	private ProvinciaDTO provincia;
}