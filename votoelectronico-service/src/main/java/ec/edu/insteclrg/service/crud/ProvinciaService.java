package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Provincia;
import ec.edu.insteclrg.dto.ProvinciaDTO;
import ec.edu.insteclrg.persistence.ProvinciaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProvinciaService extends GenericCrudServiceImpl<Provincia, ProvinciaDTO> {

	@Autowired
	private ProvinciaRepository repository;
	
	private ModelMapper modelMapper=new ModelMapper();

	@Override
	public Optional<Provincia> find(ProvinciaDTO dto) {
		return repository.findById(dto.getId());
	}

//el traspaso de unos datos de un objeto entity a otra entity
	@Override
	public ProvinciaDTO mapToDto(Provincia domain) {
		ProvinciaDTO provincia = modelMapper.map(domain, ProvinciaDTO.class);
		return provincia;
	}

	@Override
	public Provincia mapToDomain(ProvinciaDTO dto) {
// llamamos a la entidad, uzando modelmapper 
		Provincia provincia = modelMapper.map(dto, Provincia.class);

		return provincia;
	}


	public void update(long id, ProvinciaDTO dto) {
		ProvinciaDTO provinciadto= new ProvinciaDTO() ;
		provinciadto.setId(id);
		Optional<Provincia> optionalProvincia=repository.findById(provinciadto.getId());
		if (!optionalProvincia.isPresent()) {
			throw new ResourceNotFoundException(String.format("Esta provincia %s no se encuentra registrado"));
		}
		dto.setId(id);
	   Provincia provincia =  mapToDomain(dto);
		repository.save(provincia);
	
	}

	
		
	}


