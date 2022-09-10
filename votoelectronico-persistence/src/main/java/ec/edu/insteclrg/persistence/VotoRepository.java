package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	@Query(value = "SELECT * FROM voto WHERE votante_id=?1  and procesoeleccion_id=?2", nativeQuery = true)
	Optional<Voto> buscarPorIdVotante(String idVotante,String idProcesoEleccion);
}

