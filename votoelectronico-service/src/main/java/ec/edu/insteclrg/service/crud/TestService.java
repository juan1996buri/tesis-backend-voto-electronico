package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.dto.TestDTO;
import ec.edu.insteclrg.persistence.TestRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TestService extends GenericCrudServiceImpl<Test, TestDTO> {

	@Autowired
	private TestRepository repository;

	@Override
	public Optional<Test> find(TestDTO dto) {
		return repository.findByCode(dto.getCode());
	}

	@Override
	public TestDTO mapToDto(Test domain) {
		TestDTO testDTO = new TestDTO();
		testDTO.setId(domain.getId());
		testDTO.setCode(domain.getCode());
		testDTO.setName(domain.getName());
		return testDTO;
	}

	@Override
	public Test mapToDomain(TestDTO dto) {
		Test test = new Test();
		test.setId(dto.getId());
		test.setCode(dto.getCode());
		test.setName(dto.getName());
		return test;
	}

	public void update(String code, TestDTO dto) {
		TestDTO testDto = new TestDTO();
		testDto.setCode(code);
		Optional<Test> optionalTest = repository.findByCode(testDto.getCode());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", code));
		}
		Test test = optionalTest.get();
		test.setName(dto.getName());
		repository.save(test);
	}
}
