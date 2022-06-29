package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Grupo;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.GrupoDTO;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.GrupoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class GrupoService extends GenericCrudServiceImpl<Grupo, GrupoDTO> {

	@Autowired
	private GrupoRepository repository;
	
	private ModelMapper modelMapper=new ModelMapper();
	
	
	@Override
	public Optional<Grupo> find(GrupoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public GrupoDTO mapToDto(Grupo domain) {
		GrupoDTO dto=modelMapper.map(domain, GrupoDTO.class);
	    return dto;		
	}

	@Override
	public Grupo mapToDomain(GrupoDTO dto) {
		Grupo domain=modelMapper.map(dto, Grupo.class);
		return domain;
	}
	
	public void update(Long id, GrupoDTO dto) {
		GrupoDTO grupoDto = new GrupoDTO();
		grupoDto.setId(id);
		Optional<Grupo> optionalGrupo = repository.findById(grupoDto.getId());
		if (!optionalGrupo.isPresent()) {
			throw new ResourceNotFoundException(String.format("El Grupo %s no se encuentra registrado"));
		}
		Grupo grupo = optionalGrupo.get();
		grupo.setName(dto.getName());
		//grupo.setJunta(dto.getJunta());
		
		repository.save(grupo);		
	}

	
}
