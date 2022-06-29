package ec.edu.insteclrg.service.crud;

import java.util.Optional;

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
	
	@Override
	public Optional<Votante> find(VotanteDTO dto) {
		return repository.findByCedula(dto.getCedula());
	}
	
	@Override
	public VotanteDTO mapToDto(Votante domain) {
		VotanteDTO dto=new VotanteDTO();
		dto.setId(domain.getId());
		dto.setCedula(domain.getCedula());
		dto.setCode(domain.getCode());
		dto.setEmail(domain.getEmail());
		dto.setLastName(domain.getLastName());
		dto.setName(domain.getName());
		dto.setPhone(domain.getPhone());
		dto.setPhoto(domain.getPhoto());
	    dto.setIsActive(domain.getIsActive());
		return dto;
	}

	@Override
	public Votante mapToDomain(VotanteDTO dto) {
		Votante domain = new Votante();
		domain.setId(dto.getId());
		domain.setCedula(dto.getCedula());
		domain.setCode(dto.getCode());
		domain.setEmail(dto.getEmail());
		domain.setLastName(dto.getLastName());
		domain.setName(dto.getName());
		domain.setPhone(dto.getPhone());
		domain.setPhoto(dto.getPhoto());
		domain.setIsActive(dto.getIsActive());
		return domain;
	}
	
	public void update(String cedula, VotanteDTO dto) {
		VotanteDTO votanteDto = new VotanteDTO();
		votanteDto.setCedula(cedula);
		Optional<Votante> optionalVotante = repository.findByCedula(votanteDto.getCedula());
		if (!optionalVotante.isPresent()) {
			throw new ResourceNotFoundException(String.format("El votante %s no se encuentra registrado", cedula));
		}
		Votante votante = optionalVotante.get();
		votante.setName(dto.getName());
		votante.setCedula(dto.getCedula());
		votante.setCode(dto.getCode());
		votante.setEmail(dto.getEmail());
		votante.setLastName(dto.getLastName());
		votante.setPhone(dto.getPhone());
		votante.setPhoto(dto.getPhoto());
		votante.setIsActive(dto.getIsActive());
		repository.save(votante);		
	}

}
