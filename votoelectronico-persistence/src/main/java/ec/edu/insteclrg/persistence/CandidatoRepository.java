package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

}
