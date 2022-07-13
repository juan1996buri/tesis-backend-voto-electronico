package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Sexo;
@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long> {



}
