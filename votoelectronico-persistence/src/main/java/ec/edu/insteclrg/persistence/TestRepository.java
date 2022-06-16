package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.insteclrg.domain.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

	Optional<Test> findByCode(String code);
}
