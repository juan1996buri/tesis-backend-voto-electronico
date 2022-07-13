package ec.edu.insteclrg.service.crud;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.ProcesoEleccion;
import ec.edu.insteclrg.dto.ProcesoEleccionDTO;
import ec.edu.insteclrg.persistence.ProcesoEleccionRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProcesoEleccionService extends GenericCrudServiceImpl<ProcesoEleccion, ProcesoEleccionDTO> {

	@Autowired
	private ProcesoEleccionRepository repository;

	private ModelMapper modelmapper = new ModelMapper();

	@Override
	public ProcesoEleccionDTO mapToDto(ProcesoEleccion domainObject) {
		ProcesoEleccionDTO dto = modelmapper.map(domainObject, ProcesoEleccionDTO.class);
		return dto;
	}

	@Override
	public ProcesoEleccion mapToDomain(ProcesoEleccionDTO dtoObject) {
		ProcesoEleccion domain = modelmapper.map(dtoObject, ProcesoEleccion.class);
		return domain;
	}

	@Override
	public Optional<ProcesoEleccion> find(ProcesoEleccionDTO dtoObject) {
		return repository.findById(dtoObject.getId());
	}

	public void update(ProcesoEleccionDTO dto) {
		ProcesoEleccionDTO procesoEleccionDto = new ProcesoEleccionDTO();
		Optional<ProcesoEleccion> optionalProcesoEleccion = repository.findById(procesoEleccionDto.getId());
		if (!optionalProcesoEleccion.isPresent()) {
			throw new ResourceNotFoundException(String.format("El procesoeleccion %s no se encuentra registrado"));
		}
		ProcesoEleccion procesoeleccion = mapToDomain(dto);
		repository.save(procesoeleccion);
	}

	@Override
	public void delete(ProcesoEleccionDTO dtoObject) {
		
		
	}
}
