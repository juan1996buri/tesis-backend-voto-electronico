package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class CiudadDTO {

	private long id;

	private String name;
//relacion con  la provicncia
	private ProvinciaDTO provincia;

}
