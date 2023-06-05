package primalcode.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.TipoDocumento;

// TipoDocumentoRepository.java
@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
    // Add any custom query methods or overrides if needed
}