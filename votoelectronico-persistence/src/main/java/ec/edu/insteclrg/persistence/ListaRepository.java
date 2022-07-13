package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{

}
