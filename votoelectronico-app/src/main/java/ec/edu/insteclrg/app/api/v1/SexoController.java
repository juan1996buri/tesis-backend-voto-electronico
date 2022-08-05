package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;
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
import ec.edu.insteclrg.domain.Sexo;
import ec.edu.insteclrg.dto.SexoDTO;
import ec.edu.insteclrg.service.crud.SexoService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping (value = "api/v1.0/sexo")
public class SexoController {
	
	@Autowired
	SexoService service;
	
	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody SexoDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "El sexo a sido guardado"), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> actualizar(@RequestBody SexoDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "El sexo a sido actualizado"), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		List<SexoDTO> list = service.findAll(new SexoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<SexoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}/buscar")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		SexoDTO dto = new SexoDTO();
		dto.setId(id);
		Optional<Sexo> domain = service.find(dto);
		if (!domain.isEmpty()) {
			dto = service.mapToDto(domain.get());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		SexoDTO dto = new SexoDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "El sexo a sido eliminado"), HttpStatus.CREATED);
	}
	
}
