package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Recinto;

@Repository
public interface RecintoRepository extends JpaRepository<Recinto, Long> {
	
}
