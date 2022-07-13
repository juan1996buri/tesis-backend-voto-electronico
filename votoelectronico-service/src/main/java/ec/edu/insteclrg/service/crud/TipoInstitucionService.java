package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
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
	
	ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public Optional<TipoInstitucion> find(TipoInstitucionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoInstitucionDTO mapToDto(TipoInstitucion domain) {
		TipoInstitucionDTO tipoDTO=modelMapper.map(domain, TipoInstitucionDTO.class);
		return tipoDTO;
	}

	@Override
	public TipoInstitucion mapToDomain(TipoInstitucionDTO dto) {
		TipoInstitucion tipoInstitucion = modelMapper.map(dto, TipoInstitucion.class);
		return tipoInstitucion;
	}
	
	public void delete(TipoInstitucionDTO  dto) {
		Optional<TipoInstitucion> optionalTipoInstitucion = repository.findById(dto.getId());
		if (!optionalTipoInstitucion.isPresent()) {
			throw new ResourceNotFoundException(String.format("El tipo de institucion %s no existe"));
		}
		TipoInstitucion tipoinstitucion = optionalTipoInstitucion.get();
		repository.delete(tipoinstitucion);
	}
}
