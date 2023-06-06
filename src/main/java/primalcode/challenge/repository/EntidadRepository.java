package primalcode.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.model.TipoDocumentoContribuyenteDTO;

import java.util.List;

// EntidadRepository.java
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
    // Add any custom query methods or overrides if needed
    @Query("SELECT e FROM Entidad e JOIN FETCH e.tipoDocumento JOIN FETCH e.tipoContribuyente")
    List<Entidad> findAllWithNames();

    /*
    @Query("SELECT new primalcode.challenge.model.TipoDocumentoContribuyenteDTO(td.idTipoDocumento, td.codigo, td.nombre, td.descripcion, tc.idTipoContribuyente, tc.nombre) FROM TipoDocumento td, TipoContribuyente tc")
    List<TipoDocumentoContribuyenteDTO> findAllTipoDocumentoAndTipoContribuyente();
   */
    /*
    @Query("SELECT new primalcode.challenge.model.TipoDocumentoContribuyenteDTO(td.idTipoDocumento, td.codigo, td.nombre, td.descripcion, tc.idTipoContribuyente, tc.nombre) FROM TipoDocumento td JOIN TipoContribuyente tc ON td.estado = true AND tc.estado = true")
    List<TipoDocumentoContribuyenteDTO> findAllTipoDocumentoAndTipoContribuyente();
*/
    /*
    @Query(value = "SELECT td.id_tipo_documento, td.codigo, td.nombre, td.descripcion, tc.id_tipo_contribuyente, tc.nombre FROM tb_tipo_documento td, tb_tipo_contribuyente tc WHERE td.estado = true AND tc.estado = true", nativeQuery = true)
    List<Object[]> findAllTipoDocumentoAndTipoContribuyente();
    */
}