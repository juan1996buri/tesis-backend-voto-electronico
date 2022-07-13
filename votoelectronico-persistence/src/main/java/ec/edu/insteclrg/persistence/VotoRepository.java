package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{

}
