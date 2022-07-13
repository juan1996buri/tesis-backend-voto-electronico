package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Provincia;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.ProvinciaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {

	@Autowired
	private ProvinciaRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Provincia> find(ProvinciaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ProvinciaDTO mapToDto(Provincia domain) {
		ProvinciaDTO provincia = modelMapper.map(domain, ProvinciaDTO.class);
		return provincia;
	}

	@Override
	public Provincia mapToDomain(ProvinciaDTO dto) {

		Provincia provincia = modelMapper.map(dto, Provincia.class);

		return provincia;
	}

	public void delete(long id, ProvinciaDTO dto) {
		ProvinciaDTO provinciaDTO = new ProvinciaDTO();
		provinciaDTO.setId(id);
		Optional<Provincia> optional = repository.findById(provinciaDTO.getId());

		if (optional.isPresent()) {
			dto.setId(optional.get().getId());
			Provincia provincia = mapToDomain(dto);
			provincia.setNombre(dto.getNombre());
			repository.delete(provincia);

		} else {
			throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", id));

		}

	}

}