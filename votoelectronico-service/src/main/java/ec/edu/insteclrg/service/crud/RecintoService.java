package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Grupo;
import ec.edu.insteclrg.domain.Recinto;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.RecintoDTO;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.RecintoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class RecintoService extends GenericCrudServiceImpl<Recinto, RecintoDTO> {

	@Autowired
	private RecintoRepository repository;
	@Override
	public Optional<Recinto> find(RecintoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public RecintoDTO mapToDto(Recinto domain) {
		return null;
	}

	@Override
	public Recinto mapToDomain(RecintoDTO dto) {
		return null;
	}
	
	public void update(long id, RecintoDTO dto) {
		RecintoDTO recintoDto = new RecintoDTO();
		recintoDto.setId(id);
		Optional<Recinto> optionalRecinto = repository.findById(dto.getId());
		if (!optionalRecinto.isPresent()) {
			throw new ResourceNotFoundException(String.format("El recinto %s no se encuentra registrado"));
		}
		Recinto recinto = optionalRecinto.get();
		recinto.setName(dto.getName());
		recinto.setDirection(dto.getDirection());
		recinto.setPhone(dto.getPhone());
		repository.save(recinto);
	}

}
