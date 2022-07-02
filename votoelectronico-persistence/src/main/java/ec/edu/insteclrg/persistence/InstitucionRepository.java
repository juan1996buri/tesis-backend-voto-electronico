package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Institucion;

@Repository
public interface  InstitucionRepository extends JpaRepository<Institucion, Long>{

	Optional<Institucion> findByUsername(String username);
}
