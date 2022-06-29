package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Junta;
import ec.edu.insteclrg.dto.JuntaDTO;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.JuntaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class JuntaService extends GenericCrudServiceImpl<Junta, JuntaDTO> {

	@Autowired
	private JuntaRepository repository;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public Optional<Junta> find(JuntaDTO dto) {		
		return repository.findById(dto.getId());
	}

	@Override
	public JuntaDTO mapToDto(Junta domain) {
		JuntaDTO dto=modelMapper.map(domain, JuntaDTO.class);
		return dto;
	}

	@Override
	public Junta mapToDomain(JuntaDTO dto) {
		Junta domain=modelMapper.map(dto, Junta.class);
		return domain;
	}

	public void update(long id, JuntaDTO dto) {
		JuntaDTO juntaDto = new JuntaDTO();
		juntaDto.setId(id);		
		Optional<Junta> optionalJunta = repository.findById(juntaDto.getId());
		if (!optionalJunta.isPresent()) {
			throw new ResourceNotFoundException(String.format("Esta junta %s no se encuentra registrado"));
		}
		dto.setId(id);
		Junta junta = mapToDomain(dto);
		repository.save(junta);
	}

}
