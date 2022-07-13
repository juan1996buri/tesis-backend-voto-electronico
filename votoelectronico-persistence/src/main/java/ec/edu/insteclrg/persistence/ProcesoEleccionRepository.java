package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.insteclrg.domain.ProcesoEleccion;

@Repository
public interface ProcesoEleccionRepository extends JpaRepository<ProcesoEleccion, Long> {

}
