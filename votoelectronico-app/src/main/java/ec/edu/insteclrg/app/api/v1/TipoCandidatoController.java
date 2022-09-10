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
import ec.edu.insteclrg.domain.TipoCandidato;
import ec.edu.insteclrg.dto.TipoCandidatoDTO;

import ec.edu.insteclrg.service.crud.TipoCandidatoService;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping(value = "/api/v1.0/tipoCandidato")
public class TipoCandidatoController {

	@Autowired
	private TipoCandidatoService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TipoCandidatoDTO dto) {
	
		return new ResponseEntity<>(new ApiResponseDTO<>(true, service.save(dto)), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody TipoCandidatoDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<TipoCandidatoDTO> list = service.findAll(new TipoCandidatoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<TipoCandidatoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable long id) {
		TipoCandidatoDTO tipoDTO = new TipoCandidatoDTO();
		tipoDTO.setId(id);
		Optional<TipoCandidato> tipo = service.find(tipoDTO);
		if (tipo.isPresent()) {
			ApiResponseDTO<TipoCandidato> response = new ApiResponseDTO<>(true, tipo.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		TipoCandidatoDTO dto = new TipoCandidatoDTO();
		dto.setId(id);
		service.delete(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}
}