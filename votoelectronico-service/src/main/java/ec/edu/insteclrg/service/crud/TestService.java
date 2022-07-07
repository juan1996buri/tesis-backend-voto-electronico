package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.dto.TestDTO;
import ec.edu.insteclrg.persistence.TestRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TestService extends GenericCrudServiceImpl<Test, TestDTO> {

	@Autowired
	private TestRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Test> find(TestDTO dto) {
		return repository.findByCode(dto.getCode());
	}

	@Override
	public TestDTO mapToDto(Test domain) {
		return modelMapper.map(domain, TestDTO.class);
	}

	@Override
	public Test mapToDomain(TestDTO dto) {
		return modelMapper.map(dto, Test.class);
	}
}
