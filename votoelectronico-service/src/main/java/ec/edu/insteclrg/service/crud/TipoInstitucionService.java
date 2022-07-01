package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.TipoInstitucion;
import ec.edu.insteclrg.dto.TipoInstitucionDTO;
import ec.edu.insteclrg.persistence.TipoInstitucionRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
@Service 
public class TipoInstitucionService extends GenericCrudServiceImpl<TipoInstitucion, TipoInstitucionDTO> {


	@Autowired
	private TipoInstitucionRepository repository;
	
	@Override
	public Optional<TipoInstitucion> find(TipoInstitucionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoInstitucionDTO mapToDto(TipoInstitucion domain) {
		TipoInstitucionDTO tipoDTO = new TipoInstitucionDTO();
		tipoDTO.setId(domain.getId());
		tipoDTO.setName(domain.getName());
		tipoDTO.setDescripcion(domain.getDescripcion());
		return tipoDTO;
	}

	@Override
	public TipoInstitucion mapToDomain(TipoInstitucionDTO dto) {
		TipoInstitucion tipoInstitucion = new TipoInstitucion();
		tipoInstitucion.setId(dto.getId());
		tipoInstitucion.setName(dto.getName());
		tipoInstitucion.setDescripcion(dto.getDescripcion());
		return tipoInstitucion;
	}

	public void update(long id, TipoInstitucionDTO dto) {
		TipoInstitucionDTO tipoDTO = new TipoInstitucionDTO();
		tipoDTO.setId(id);
		Optional<TipoInstitucion> optionalTest = repository.findById(tipoDTO.getId());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", id));
		}
		TipoInstitucion tipoInstitucion = new TipoInstitucion();
		tipoInstitucion.setName(dto.getName());
		repository.save(tipoInstitucion);
	}
	
	
	
	
}
