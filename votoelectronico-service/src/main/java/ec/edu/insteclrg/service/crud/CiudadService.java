package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Ciudad;
import ec.edu.insteclrg.dto.CiudadDTO;
import ec.edu.insteclrg.persistence.CiudadRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class CiudadService extends GenericCrudServiceImpl<Ciudad, CiudadDTO> {

	@Autowired
	private CiudadRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Ciudad> find(CiudadDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CiudadDTO mapToDto(Ciudad domain) {
		CiudadDTO ciudadDTO = modelMapper.map(domain, CiudadDTO.class);

		return ciudadDTO;
	}

	@Override
	public Ciudad mapToDomain(CiudadDTO dto) {
		Ciudad ciudad = modelMapper.map(dto, Ciudad.class);
		return ciudad;
	}

	public void delete(CiudadDTO dto) {
		Optional<Ciudad> optional = repository.findById(dto.getId());
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));

		}
		Ciudad ciudad = optional.get();
		repository.delete(ciudad);
	}
}