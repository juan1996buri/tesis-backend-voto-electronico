package ec.edu.insteclrg.dto;



import lombok.Data;

@Data
public class UserDTO {

	private long id;
	
	private String ruc;
	
	private String password;
	
	private RolesDTO roles;
	
}
