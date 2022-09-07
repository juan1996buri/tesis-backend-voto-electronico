package ec.edu.insteclrg.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Votante;

@Repository
public interface VotanteRepository extends JpaRepository<Votante, Long> {
	
	Optional<Votante> findByCedula(String cedula);
	
	Optional<Votante> findByCodigo(String codigo);
	
	@Query(value = "SELECT * FROM votante WHERE institucion_id=?1", nativeQuery = true)
	List<Votante> findByAllId(long id);

}
