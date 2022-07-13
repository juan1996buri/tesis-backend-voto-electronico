package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value = "/api/v1.0/tipoCandidato")
public class TipoCandidatoController {

	@Autowired
	TipoCandidatoService service; 
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody TipoCandidatoDTO dto){
		service.save(dto);	
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED) ;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody TipoCandidatoDTO dto ) {
		service.update(id, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		List<TipoCandidatoDTO> list = service.findAll(new TipoCandidatoDTO());
		if(!list.isEmpty()) {
			ApiResponseDTO<List<TipoCandidatoDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		}else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null),HttpStatus.NOT_FOUND);
		}			
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> find(@PathVariable long id){
		TipoCandidatoDTO tipoDTO = new TipoCandidatoDTO();
		tipoDTO.setId(id);
		Optional<TipoCandidato> tipo = service.find(tipoDTO);
		if(tipo.isPresent()) {
			ApiResponseDTO<TipoCandidato> response = new ApiResponseDTO<>(true, tipo.get());
			return(new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false,null), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		TipoCandidatoDTO dto = new TipoCandidatoDTO();
		dto.setId(id);
		service.delete(id, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true,null), HttpStatus.CREATED);
	}
}