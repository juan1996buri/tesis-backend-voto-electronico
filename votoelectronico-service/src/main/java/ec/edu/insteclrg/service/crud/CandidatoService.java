package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Candidato;
import ec.edu.insteclrg.dto.CandidatoDTO;
import ec.edu.insteclrg.persistence.CandidatoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class CandidatoService extends GenericCrudServiceImpl<Candidato, CandidatoDTO> {

	@Autowired
	private CandidatoRepository repository;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public Optional<Candidato> find(CandidatoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CandidatoDTO mapToDto(Candidato domain) {
		return modelMapper.map(domain, CandidatoDTO.class);
	}

	@Override
	public Candidato mapToDomain(CandidatoDTO dto) {
		return modelMapper.map(dto, Candidato.class);
	}

	public void delete(CandidatoDTO dto) {
		Optional<Candidato> optional = repository.findById(dto.getId());
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", dto));
		}
		Candidato candidato = optional.get();
		repository.delete(candidato);
	}
}