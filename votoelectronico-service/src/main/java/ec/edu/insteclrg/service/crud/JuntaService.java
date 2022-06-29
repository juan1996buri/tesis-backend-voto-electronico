package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Junta;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.JuntaDTO;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.JuntaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

public class JuntaService extends GenericCrudServiceImpl<Junta, JuntaDTO> {

	@Autowired
	private JuntaRepository repository;
	
	@Override
	public Optional<Junta> find(JuntaDTO dto) {
		return null;
	}

	@Override
	public JuntaDTO mapToDto(Junta domain) {
		return null;
	}

	@Override
	public Junta mapToDomain(JuntaDTO dto) {
		return null;
	}

	public void update(long id, VotanteDTO dto) {
		JuntaDTO juntaDto = new JuntaDTO();
		juntaDto.setId(id);
		Optional<Junta> optionalJunta = repository.findById(juntaDto.getId());
		if (!optionalJunta.isPresent()) {
			throw new ResourceNotFoundException(String.format("Esta junta %s no se encuentra registrado"));
		}
		Junta junta = optionalJunta.get();
		junta.setNumber(junta.getNumber());
		junta.setPresident(junta.getPresident());
		junta.setRecinto(junta.getRecinto());
		junta.setSecretary(junta.getSecretary());
		junta.setVicePresident(junta.getVicePresident());
		repository.save(junta);
	}

}
