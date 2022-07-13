package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Lista;
import ec.edu.insteclrg.dto.ListaDTO;
import ec.edu.insteclrg.persistence.ListaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ListaService extends GenericCrudServiceImpl<Lista, ListaDTO> {

	@Autowired
	private ListaRepository repository;
	private ModelMapper modelmapper = new ModelMapper();

	@Override
	public Optional<Lista> find(ListaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public ListaDTO mapToDto(Lista domainObject) {
		ListaDTO dto = modelmapper.map(domainObject, ListaDTO.class);
		return dto;
	}

	@Override
	public Lista mapToDomain(ListaDTO dtoObject) {
		Lista domain = modelmapper.map(dtoObject, Lista.class);
		return domain;
	}

	public void update(ListaDTO dto) {
		Optional<Lista> optionalLista = Optional.empty();
		if (!optionalLista.isPresent()) {
			throw new ResourceNotFoundException(String.format("La lista %s no se encuentra registrado"));
		}
		Lista lista = mapToDomain(dto);
		repository.save(lista);
	}

	public void delete(ListaDTO dto) {
		Optional<Lista> optionalLista = repository.findById(dto.getId());
		if (!optionalLista.isPresent()) {
			throw new ResourceNotFoundException(String.format("La lista %s no existe"));
		}
		Lista lista = optionalLista.get();
		repository.delete(lista);
	}
}
