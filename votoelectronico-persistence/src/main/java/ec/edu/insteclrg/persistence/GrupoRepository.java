package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	Optional<Grupo> findByNombre(String nombre);
}
