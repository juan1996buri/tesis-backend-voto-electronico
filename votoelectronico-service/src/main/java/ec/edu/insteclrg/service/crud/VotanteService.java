package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.VotanteRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class VotanteService extends GenericCrudServiceImpl<Votante, VotanteDTO> {

	@Autowired
	private VotanteRepository repository;
	
	ModelMapper modelMapper=new ModelMapper();	
	
	@Override
	public Optional<Votante> find(VotanteDTO dto) {
		return repository.findByCedula(dto.getCedula());
	}
	
	@Override
	public VotanteDTO mapToDto(Votante domain) {			
		VotanteDTO dto=modelMapper.map(domain, VotanteDTO.class);	
		return dto;
	}

	@Override
	public Votante mapToDomain(VotanteDTO dto) {
		Votante domain = modelMapper.map(dto, Votante.class);
		return domain;
	}
	
	public void update(String cedula, VotanteDTO dto) {
		VotanteDTO votanteDto = new VotanteDTO();
		votanteDto.setCedula(cedula);
		Optional<Votante> optionalVotante = repository.findByCedula(votanteDto.getCedula());
		if (!optionalVotante.isPresent()) {
			throw new ResourceNotFoundException(String.format("El votante %s no se encuentra registrado", cedula));
		}
		
		dto.setId(optionalVotante.get().getId());
		Votante votante=mapToDomain(dto);				
		repository.save(votante);
	}

}
