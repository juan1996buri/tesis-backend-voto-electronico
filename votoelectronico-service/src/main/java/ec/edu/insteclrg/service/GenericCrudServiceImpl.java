package ec.edu.insteclrg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.ApiException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class GenericCrudServiceImpl<DOMAIN, DTO> implements GenericCrudService<DOMAIN, DTO> {

	@Autowired
	private JpaRepository<DOMAIN, Long> repository;

	@Override
	public void save(DTO dto) {
		Optional<DOMAIN> optional = find(dto);
		if (!optional.isPresent()) {
			DOMAIN domainObject = mapToDomain(dto);
			repository.save(domainObject);
		} else {
			throw new ApiException(String.format("Registro %s ya existe en el sistema", dto));
		}
	}

	@Override
	public List<DTO> findAll(DTO dto) {
		DOMAIN domain = mapToDomain(dto);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("id");
		List<DOMAIN> objList = repository.findAll(Example.of(domain, matcher));
		return objList.stream().map(obj -> mapToDto(obj)).collect(Collectors.toList());
	}

	@Override
	public abstract DOMAIN mapToDomain(DTO dto);
}
