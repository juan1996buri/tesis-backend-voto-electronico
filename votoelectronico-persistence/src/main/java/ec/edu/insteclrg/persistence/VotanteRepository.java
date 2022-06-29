package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Votante;

@Repository
public interface VotanteRepository extends JpaRepository<Votante, Long> {
	
	Optional<Votante> findByCedula(String cedula);

}
