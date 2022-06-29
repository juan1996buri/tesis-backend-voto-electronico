package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import ec.edu.insteclrg.domain.Grupo;
import ec.edu.insteclrg.dto.GrupoDTO;
import ec.edu.insteclrg.persistence.GrupoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

public class GrupoService extends GenericCrudServiceImpl<Grupo, GrupoDTO> {

	@Autowired
	private GrupoRepository repository;
	
	
	@Override
	public Optional<Grupo> find(GrupoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public GrupoDTO mapToDto(Grupo domain) {
	return null;
		
	}

	@Override
	public Grupo mapToDomain(GrupoDTO dto) {
		return null;
	}

}
