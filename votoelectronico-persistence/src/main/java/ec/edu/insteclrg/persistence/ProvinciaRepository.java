package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Provincia;

@Repository
public interface  ProvinciaRepository extends JpaRepository <Provincia, Long>{
Optional <Provincia> findById(Long id);
	
}
