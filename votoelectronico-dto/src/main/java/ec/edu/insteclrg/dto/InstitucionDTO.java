package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class InstitucionDTO {

	private long id; 

	private String username;
	
	private String password;

	private String nombre; 

    private CiudadDTO idCiudad;  
	
	private String direccion;

	private String telefono;

	private String ruc; 

	private TipoInstitucionDTO idTipoInstitucion;
	
	private Boolean isActive; 
}
