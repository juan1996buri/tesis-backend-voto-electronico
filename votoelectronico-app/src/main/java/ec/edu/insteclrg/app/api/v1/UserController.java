package ec.edu.insteclrg.app.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.app.jwt.JwtTokenUtil;
import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.User;
import ec.edu.insteclrg.domain.UserLogin;
import ec.edu.insteclrg.dto.RolesDTO;
import ec.edu.insteclrg.dto.UserDTO;
import ec.edu.insteclrg.service.crud.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1.0/usuario")
public class UserController {
	
	/*
	 ROLE_ADMIN
	 ROLE_INSTITUTE
	 */

	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwUtil;

	@PostMapping("/registrar")
	public ResponseEntity<Object> save(@RequestBody  UserDTO dto) {
		RolesDTO role=new RolesDTO();
		role.setId(2);
		dto.setRoles(role);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true,null ), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> respuesta() {
		List<UserDTO> optional = service.findAll(new UserDTO());
		if (!optional.isEmpty()) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, optional), HttpStatus.CREATED);
		}
		return new ResponseEntity<>(new ApiResponseDTO<>(true, optional), HttpStatus.NOT_FOUND);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserLogin userLogin) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userLogin.getRuc(), userLogin.getPassword()));
			User user = (User) authentication.getPrincipal();
			String token = jwUtil.generateAccessToken(user);
			userLogin.setPassword("");
			userLogin.setToken(token);
			userLogin.setRoles(user.getRoles());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, userLogin), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping(value = "/username")
	public ResponseEntity<Object> currentUserName() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			final String currentPrincipalName = authentication.getName();
			System.out.println("Authentication: " + authentication);
			System.out.println("Principal: " + authentication.getPrincipal());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, currentPrincipalName), HttpStatus.OK);
		}

		return new ResponseEntity<>(new ApiResponseDTO<>(true, false), HttpStatus.NOT_FOUND);
	}
}
