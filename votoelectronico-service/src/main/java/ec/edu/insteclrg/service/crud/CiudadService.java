package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Ciudad;
import ec.edu.insteclrg.dto.CiudadDTO;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.CiudadRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class CiudadService extends GenericCrudServiceImpl<Ciudad, CiudadDTO> {

	@Autowired
	private CiudadRepository repository;
// usamos el modelmapper para mappear toda la clase

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Ciudad> find(CiudadDTO dto) {
		return repository.findById(dto.getId());
	}

//el traspaso de unos datos de un objeto entity a otra entity
	@Override
	public CiudadDTO mapToDto(Ciudad domain) {
		CiudadDTO ciudadDTO = modelMapper.map(domain, CiudadDTO.class);

		return ciudadDTO;
	}

	@Override
	public Ciudad mapToDomain(CiudadDTO dto) {
// llamamos a la entidad

		Ciudad ciudad = modelMapper.map(dto, Ciudad.class);
		return ciudad;
	}

//update: actualizacion
	public void update(Long id, CiudadDTO dto) {
		CiudadDTO ciudadDTO = new CiudadDTO();
		ciudadDTO.setId(id);
		Optional<Ciudad> optionalProv = repository.findById(ciudadDTO.getId());

		if (!optionalProv.isPresent()) {
			throw new ResourceNotFoundException(String.format(" el id %s no se encuentra registrado", id));
		}
		dto.setId(optionalProv.get().getId());
		Ciudad ciudad = mapToDomain(dto);
		ciudad.setName(dto.getName());
		repository.save(ciudad);

	}

	@Override
	public void update(CiudadDTO dtoObject) {

	}

}