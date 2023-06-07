package primalcode.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.Entidad;

import java.util.List;

// EntidadRepository.java
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
    // Add any custom query methods or overrides if needed
    @Query("SELECT e FROM Entidad e JOIN FETCH e.tipoDocumento JOIN FETCH e.tipoContribuyente")
    List<Entidad> findAllWithNames();
}

