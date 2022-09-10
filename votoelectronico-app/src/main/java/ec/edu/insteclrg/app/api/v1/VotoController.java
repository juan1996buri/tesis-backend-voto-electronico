package ec.edu.insteclrg.app.api.v1;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.ValidarVotoDTO;
import ec.edu.insteclrg.dto.VotoDTO;
import ec.edu.insteclrg.service.crud.VotoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1.0/voto")
public class VotoController {

	@Autowired
	private VotoService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody VotoDTO dto) {
		dto.setFechaRegistro(LocalDateTime.now());
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<VotoDTO> list = service.findAll(new VotoDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<VotoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/validar")
	public ResponseEntity<Object> obtenerVotoRealizado(@RequestBody ValidarVotoDTO dto) {
		service.obtenerVotoRealizadoPorVotante(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	}
}
