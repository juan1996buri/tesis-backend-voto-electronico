package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.Junta;
import ec.edu.insteclrg.dto.JuntaDTO;
import ec.edu.insteclrg.service.crud.JuntaService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1.0/junta")
public class JuntaController {
	
	@Autowired
	private JuntaService service;
	
	@PostMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> save(@RequestBody JuntaDTO dto) {
		
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.save(dto) ), HttpStatus.CREATED);
	}

	@PutMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> update(@RequestBody JuntaDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> findAll() {
		List<JuntaDTO> list = service.findAll(new JuntaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<JuntaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		JuntaDTO dto = new JuntaDTO();
		dto.setId(id);
		Optional<Junta> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<Junta> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		JuntaDTO dto = new JuntaDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}	
}
