package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Institucion;
import ec.edu.insteclrg.dto.InstitucionDTO;
import ec.edu.insteclrg.persistence.InstitucionRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

public class InstitucionService extends GenericCrudServiceImpl<Institucion, InstitucionDTO>  {

	@Autowired
	private InstitucionRepository repository; 
	
	ModelMapper modelMapper=new ModelMapper(); 
	
	@Override
	public Optional<Institucion> find(InstitucionDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public InstitucionDTO mapToDto(Institucion domain) {
		InstitucionDTO dto=modelMapper.map(domain, InstitucionDTO.class); 
		return dto;
	}

	@Override
	public Institucion mapToDomain(InstitucionDTO dto) {
		Institucion domain=modelMapper.map(dto, Institucion.class);
		return domain;
	}
	
	public void update(String username,InstitucionDTO dto) {
		InstitucionDTO institucionDTO= new InstitucionDTO();
		institucionDTO.setUsername(username);
		Optional<Institucion> optional = repository.findByUsername(institucionDTO.getUsername());
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException(String.format("El votante %s no se encuentra registrado", username)); 
		}
		dto.setId(optional.get().getId());
		Institucion institucion=mapToDomain(dto);
		repository.save(institucion);
	}
}






