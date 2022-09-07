package ec.edu.insteclrg.service.crud;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.ApiException;
import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Votante;
import ec.edu.insteclrg.dto.VotanteCodigoDTO;
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
	
	
	public String generarIdentificador(long idInstitucion) {
		Set<Integer> codigosExistentes = new HashSet<>();
		List<Votante> votantes = repository.findByAllId(idInstitucion);

		String idIns = String.valueOf(idInstitucion);

		for (int i = 0; i < votantes.size(); i++) {
			if (votantes.get(i).getCodigo()!=null) {
				int tamano = votantes.get(i).getCodigo().length() - idIns.length();
				if (tamano == 8) {
					codigosExistentes.add(Integer.parseInt(votantes.get(i).getCodigo().substring(0,
							votantes.get(i).getCodigo().length() - idIns.length())));
				}
			}

		}

		Random r = new Random();
		boolean existe = false;
		int codigoValido = 0;

		while (codigosExistentes.size() < 99999999 && existe == false) {
			int codigoGenerado = r.nextInt(90000000) + 10000000;
			if (!codigosExistentes.contains(codigoGenerado)) {
				codigoValido = codigoGenerado;
				codigosExistentes.add(codigoGenerado);
				existe = true;
			}
		}
		return String.valueOf(codigoValido) + idInstitucion;
	}

/*	public String generarIdentificador(VotanteCodigoDTO dto) {
		Set<Integer> codigosExistentes = new HashSet<>();
		List<Votante> votantes = repository.findByAllId(dto.getInstitucion().getId());

		String idIns = String.valueOf(dto.getInstitucion().getId());

		for (int i = 0; i < votantes.size(); i++) {
			if (votantes.get(i).getCodigo()!=null) {
				int tamano = votantes.get(i).getCodigo().length() - idIns.length();
				if (tamano == 8) {
					codigosExistentes.add(Integer.parseInt(votantes.get(i).getCodigo().substring(0,
							votantes.get(i).getCodigo().length() - idIns.length())));
				}
			}

		}

		Random r = new Random();
		boolean existe = false;
		int codigoValido = 0;

		while (codigosExistentes.size() < 99999999 && existe == false) {
			int codigoGenerado = r.nextInt(90000000) + 10000000;
			if (!codigosExistentes.contains(codigoGenerado)) {
				codigoValido = codigoGenerado;
				codigosExistentes.add(codigoGenerado);
				existe = true;
			}
		}
		return String.valueOf(codigoValido) + dto.getInstitucion().getId();
	}*/

	public VotanteDTO logear(String codigo) {
		Optional<Votante> optional = repository.findByCodigo(codigo);
		if (optional.isPresent()) {
			return mapToDto(optional.get());
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
