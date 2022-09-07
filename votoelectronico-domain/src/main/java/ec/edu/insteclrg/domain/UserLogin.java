package ec.edu.insteclrg.domain;

import lombok.Data;

@Data
public class UserLogin {
	
	private String ruc;
	
	private String password;
	
	private String token;
	
	private Role roles;
}
