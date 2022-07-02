package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class InstitucionDTO {

	private long id; 

	private String username;
	
	private String password;

	private String name; 

    private CiudadDTO idCiudad;  
	
	private String direction;

	private String phone;

	private String ruc; 

	private TipoInstitucionDTO idTipoInstitucion;
	
	private Boolean isActive; 
}
