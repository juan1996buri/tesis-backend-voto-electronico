package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class VotanteDTO {
	
	private long id;
	
	private String cedula;    
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private String celular;
	
	private String codigo;
	
	private Boolean activo;
	
	private GrupoDTO grupo;	
	
	private InstitucionDTO institucion; 

    private SexoDTO sexo; 
}
