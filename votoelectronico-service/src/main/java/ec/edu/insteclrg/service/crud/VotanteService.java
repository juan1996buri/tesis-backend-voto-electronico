package ec.edu.insteclrg.service.crud;


import java.util.Optional;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.ApiException;
import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.VotanteDTO;
import ec.edu.insteclrg.persistence.VotanteRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class VotanteService extends GenericCrudServiceImpl<Votante, VotanteDTO> {

	@Autowired
	private VotanteRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Votante> find(VotanteDTO dto) {
		return repository.findByCedula(dto.getCedula());
	}

	@Override
	public VotanteDTO mapToDto(Votante domain) {
		VotanteDTO dto = modelMapper.map(domain, VotanteDTO.class);
		return dto;
	}

	@Override
	public Votante mapToDomain(VotanteDTO dto) {
		Votante domain = modelMapper.map(dto, Votante.class);
		return domain;
	}

	public String generarIdentificador(String idInstitucion) {
		boolean encontrado = false;
		Random r = new Random();
		String codigoValido="";
		do {
			String codigoGenerado = String.valueOf((r.nextInt(90000000) + 10000000));
			String validarCodigo = codigoGenerado + idInstitucion;
			Optional<Votante> optional = repository.findByAllId(idInstitucion, validarCodigo);
			if(!optional.isPresent()) {
				codigoValido=validarCodigo;
				encontrado=true;
			}			
		}while(encontrado==false);
		
		return codigoValido;
	}

	public VotanteDTO login(String codigo) {
		Optional<Votante> optional = repository.findByCodigo(codigo);
		if (optional.isPresent()) {
			VotanteDTO dto=mapToDto(optional.get());
			dto.setCodigo("");
			return dto;
		} else {
			throw new ApiException(String.format("Registro %s no existe en el sistema", codigo));
		}
	}

	public void delete(VotanteDTO dto) {
		Optional<Votante> optionalVotante = repository.findById(dto.getId());
		if (!optionalVotante.isPresent()) {
			throw new ResourceNotFoundException(String.format("El recinto %s no existe"));
		}
		Votante votante = optionalVotante.get();
		repository.delete(votante);
	}
}
