package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Recinto;
import ec.edu.insteclrg.dto.RecintoDTO;
import ec.edu.insteclrg.persistence.RecintoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class RecintoService extends GenericCrudServiceImpl<Recinto, RecintoDTO> {

	@Autowired
	private RecintoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Recinto> find(RecintoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public RecintoDTO mapToDto(Recinto domain) {
		RecintoDTO dto = modelMapper.map(domain, RecintoDTO.class);
		return dto;
	}

	@Override
	public Recinto mapToDomain(RecintoDTO dto) {
		Recinto domain = modelMapper.map(dto, Recinto.class);
		return domain;
	}

	public void update(long id, RecintoDTO dto) {
		RecintoDTO recintoDto = new RecintoDTO();
		recintoDto.setId(id);
		Optional<Recinto> optionalRecinto = repository.findById(recintoDto.getId());
		if (!optionalRecinto.isPresent()) {
			throw new ResourceNotFoundException(String.format("El recinto %s no se encuentra registrado"));
		}
		dto.setId(id);
		Recinto recinto = mapToDomain(dto);
		repository.save(recinto);
	}

	public void delete(RecintoDTO dto) {
		Optional<Recinto> optionalRecinto = repository.findById(dto.getId());
		if (!optionalRecinto.isPresent()) {
			throw new ResourceNotFoundException(String.format("El recinto %s no existe"));
		}
		Recinto grupo = optionalRecinto.get();
		repository.delete(grupo);
	}
}
