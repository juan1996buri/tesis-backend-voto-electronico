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
import ec.edu.insteclrg.domain.Lista;
import ec.edu.insteclrg.dto.ListaDTO;
import ec.edu.insteclrg.service.crud.ListaService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping (path = "api/v1.0/lista")
public class ListaController {

	@Autowired
	ListaService service;

	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody ListaDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "Lista guardada con exito"), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> actualizar(@RequestBody ListaDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "Lista actualizada con exito"), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> listar() {
		List<ListaDTO> list = service.findAll(new ListaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ListaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}/buscar")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		ListaDTO dto = new ListaDTO();
		dto.setId(id);
		Optional<Lista> domain = service.find(dto);
		if (!domain.isEmpty()) {
			dto = service.mapToDto(domain.get());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		ListaDTO dto = new ListaDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, "Lista eliminada con exito"), HttpStatus.CREATED);
	}

}
