package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.ApiException;
import ec.edu.insteclrg.domain.Voto;
import ec.edu.insteclrg.dto.ValidarVotoDTO;
import ec.edu.insteclrg.dto.VotoDTO;
import ec.edu.insteclrg.persistence.VotoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class VotoService extends GenericCrudServiceImpl<Voto, VotoDTO> {

	@Autowired
	private VotoRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Voto> find(VotoDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public VotoDTO mapToDto(Voto domain) {
		return modelMapper.map(domain, VotoDTO.class);
	}

	@Override
	public Voto mapToDomain(VotoDTO dto) {
		return modelMapper.map(dto, Voto.class);
	}

	public VotoDTO obtenerVotoRealizadoPorVotante(ValidarVotoDTO dto) {
		
		Optional<Voto> optional = repository.buscarPorIdVotante(dto.getIdVotante(), dto.getIdProcesoEleccion());
		if (optional.isPresent()) {
			VotoDTO votoDTO = mapToDto(optional.get());
			votoDTO.getVotante().setCodigo("");
			//return votoDTO;
			throw new ApiException(String.format("Registro %s no existe en el sistema", dto));
		} else {
			return null;
		}
	}
}
