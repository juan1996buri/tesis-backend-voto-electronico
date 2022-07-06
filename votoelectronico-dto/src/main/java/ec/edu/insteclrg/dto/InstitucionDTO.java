package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class InstitucionDTO {

	private long id; 

	private String username;
	
	private String password;

	private String name; 

    private CiudadDTO ciudad;  
	
	private String direction;

	private String phone;

	private String ruc; 

	private TipoInstitucionDTO tipoInstitucion;
	
	private Boolean isActive; 
}
