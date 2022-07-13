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
	
	ModelMapper modelMapper=new ModelMapper();
	
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

	public void delete(TipoCandidatoDTO dto) {
		Optional<TipoCandidato> optionalTipoCandidato = repository.findById(dto.getId());
		if (!optionalTipoCandidato.isPresent()) {
			throw new ResourceNotFoundException(String.format("El tipo candidato %s no existe"));
		}
		TipoCandidato tipoCandidato= optionalTipoCandidato.get();
		repository.delete(tipoCandidato);
	}
}