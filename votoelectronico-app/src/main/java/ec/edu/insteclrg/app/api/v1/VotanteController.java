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
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.service.crud.VotanteService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1.0/votante")
public class VotanteController {

	@Autowired
	private VotanteService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody VotanteDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody VotanteDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> findAll() {
		List<VotanteDTO> list = service.findAll(new VotanteDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<VotanteDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{cedula}")
	public ResponseEntity<Object> find(@PathVariable String cedula) {
		VotanteDTO dto = new VotanteDTO();
		dto.setCedula(cedula);
		Optional<Votante> test = service.find(dto);
		if (test.isPresent()) {
			ApiResponseDTO<Votante> response = new ApiResponseDTO<>(true, test.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "/logeo/{codigo}")
	public ResponseEntity<Object> logeo(@PathVariable String codigo) {		
			return new ResponseEntity<>(new ApiResponseDTO<>(true, service.logear(codigo)), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/codigo/{id}")
	public ResponseEntity<Object> codigo(@PathVariable String id) {
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.generarIdentificador(id)), HttpStatus.CREATED);		
	}
	
	@DeleteMapping(path = "/{id}")
	@RolesAllowed("ROLE_INSTITUTE")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		VotanteDTO dto = new VotanteDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}
	
}
