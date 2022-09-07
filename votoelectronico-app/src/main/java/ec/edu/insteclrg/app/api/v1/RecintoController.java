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
import ec.edu.insteclrg.domain.Recinto;
import ec.edu.insteclrg.dto.RecintoDTO;
import ec.edu.insteclrg.service.crud.RecintoService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1.0/recinto")
public class RecintoController {
	
	@Autowired
	private RecintoService service;
	
	@PostMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> save(@RequestBody RecintoDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> update(@RequestBody RecintoDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> findAll() {
		List<RecintoDTO> list = service.findAll(new RecintoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<RecintoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> find(@PathVariable Long id) {
		RecintoDTO dto = new RecintoDTO();
		dto.setId(id);
		Optional<Recinto> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<Recinto> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		RecintoDTO dto = new RecintoDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}
}
