package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ec.edu.insteclrg.domain.Sexo;
import ec.edu.insteclrg.dto.SexoDTO;
import ec.edu.insteclrg.persistence.SexoRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;
@Service
public class SexoService  extends GenericCrudServiceImpl<Sexo, SexoDTO> {

	@Autowired
	SexoRepository repository;
	
	@Override
	public SexoDTO mapToDto(Sexo domainObject) {
		SexoDTO sexodto = new SexoDTO();
		sexodto.setId(domainObject.getId());
		sexodto.setNombre(domainObject.getNombre());
		return sexodto;
	}
	
	@Override
	public Sexo mapToDomain(SexoDTO dtoObject) {
		Sexo sexo = new Sexo();
		sexo.setId(dtoObject.getId());
		sexo.setNombre(dtoObject.getNombre());
		return sexo;
	}

	@Override
	public Optional<Sexo> find(SexoDTO dtoObject) {
		return repository.findById(dtoObject.getId());
	}

}
