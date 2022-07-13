package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.domain.TipoCandidato;

@Repository
public interface TipoCandidatoRepository extends JpaRepository<TipoCandidato, Long>  {

	Optional<TipoCandidato> findById(long id);
}
