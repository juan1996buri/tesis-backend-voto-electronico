package ec.edu.insteclrg.dto;
import lombok.Data;

@Data
public class InstitucionDTO {

	private long id; 

	private String correo;
	
	private String logo;

	private String nombre; 

    private CiudadDTO ciudad;  
	
	private String direccion;

	private String telefono;

	private String ruc; 

	private TipoInstitucionDTO tipoInstitucion;
	
	private Boolean activo; 
}
