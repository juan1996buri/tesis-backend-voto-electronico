package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Institucion;
import ec.edu.insteclrg.dto.InstitucionDTO;
import ec.edu.insteclrg.persistence.InstitucionRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
@Service 
public class InstitucionService extends GenericCrudServiceImpl<Institucion, InstitucionDTO>  {

	@Autowired
	private InstitucionRepository repository; 
	
	ModelMapper modelMapper=new ModelMapper(); 
	
	@Override
	public Optional<Institucion> find(InstitucionDTO dto) {
		return repository.findByRuc(dto.getRuc());
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
}