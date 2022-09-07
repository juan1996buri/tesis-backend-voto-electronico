package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
