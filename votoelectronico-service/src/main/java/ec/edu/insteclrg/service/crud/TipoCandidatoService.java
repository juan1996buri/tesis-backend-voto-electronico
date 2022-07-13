package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.TipoCandidato;
import ec.edu.insteclrg.dto.TipoCandidatoDTO;
import ec.edu.insteclrg.persistence.TipoCandidatoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TipoCandidatoService extends GenericCrudServiceImpl<TipoCandidato, TipoCandidatoDTO> {

	@Autowired
	private TipoCandidatoRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<TipoCandidato> find(TipoCandidatoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TipoCandidatoDTO mapToDto(TipoCandidato domain) {
		TipoCandidatoDTO tipoDTO = modelMapper.map(domain, TipoCandidatoDTO.class);
		return tipoDTO;
	}

	@Override
	public TipoCandidato mapToDomain(TipoCandidatoDTO dto) {
		TipoCandidato tipo = modelMapper.map(dto, TipoCandidato.class);
		return tipo;
	}

	public void update(Long id, TipoCandidatoDTO dto) {
		TipoCandidatoDTO tipoDTO = new TipoCandidatoDTO();
		tipoDTO.setId(id);
		Optional<TipoCandidato> optional = repository.findById(tipoDTO.getId());

		if (!optional.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", id));
		}
		TipoCandidato tipocandidato = optional.get();
		tipocandidato.setName(dto.getName());
		repository.save(tipocandidato);
	}

	public void delete(long id, TipoCandidatoDTO dto) {
		TipoCandidatoDTO tipoDto = new TipoCandidatoDTO();
		tipoDto.setId(id);
		Optional<TipoCandidato> optional = repository.findById(tipoDto.getId());

		if (optional.isPresent()) {
			dto.setId(optional.get().getId());
			TipoCandidato candidato = mapToDomain(dto);
			repository.delete(candidato);
		} else {
			throw new ResourceNotFoundException(String.format("Registro %s no existe en la base de datos", id));
		}
	}
}