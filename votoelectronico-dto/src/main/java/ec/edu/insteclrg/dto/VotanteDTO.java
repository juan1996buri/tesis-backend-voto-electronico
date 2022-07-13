package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class VotanteDTO {
	
	private long id;
	
	private String cedula;    
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private byte[] photo;	
	
	private String phone;
	
	private String code;
	
	private Boolean isActive;
	
	private GrupoDTO grupo;	
	
	private InstitucionDTO institucion; 

    private SexoDTO sexo; 
	
}
