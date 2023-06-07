package primalcode.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.TipoDocumento;

import java.util.List;

// TipoDocumentoRepository.java
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
    // Add any custom query methods or overrides if needed
    List<TipoDocumento> findAllByEstadoTrue();

    /*@Query("SELECT td.idTipoDocumento, td.nombre FROM TipoDocumento td WHERE td.estado = true")
    List<Object[]> findAllTipoDocumentos();*/
}