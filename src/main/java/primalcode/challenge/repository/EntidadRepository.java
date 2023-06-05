package primalcode.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.Entidad;

// EntidadRepository.java
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
    // Add any custom query methods or overrides if needed
}