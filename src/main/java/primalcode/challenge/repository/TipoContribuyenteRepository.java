package primalcode.challenge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.TipoContribuyente;

import java.util.List;

// TipoContribuyenteRepository.java
@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {
    // Add any custom query methods or overrides if needed
    List<TipoContribuyente> findAllByEstadoTrue();
   /* @Query("SELECT tc.idTipoContribuyente, tc.nombre FROM TipoContribuyente tc WHERE tc.estado = true")
    List<Object[]> findAllTipoContribuyentes();*/
}