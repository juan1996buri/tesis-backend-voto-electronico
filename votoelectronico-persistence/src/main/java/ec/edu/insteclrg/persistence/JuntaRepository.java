package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Junta;

@Repository
public interface JuntaRepository extends JpaRepository<Junta, Long> {
	
}
