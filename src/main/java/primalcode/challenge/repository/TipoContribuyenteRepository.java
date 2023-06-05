package primalcode.challenge.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.TipoContribuyente;

// TipoContribuyenteRepository.java
@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {
    // Add any custom query methods or overrides if needed
}