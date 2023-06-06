package primalcode.challenge.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.model.TipoContribuyente;
import primalcode.challenge.model.TipoDocumento;
import primalcode.challenge.model.TipoDocumentoContribuyenteDTO;
import primalcode.challenge.repository.EntidadRepository;
import primalcode.challenge.repository.TipoContribuyenteRepository;
import primalcode.challenge.repository.TipoDocumentoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntidadService {
    private final EntidadRepository entidadRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    public EntidadService(EntidadRepository entidadRepository, TipoDocumentoRepository tipoDocumentoRepository, TipoContribuyenteRepository tipoContribuyenteRepository) {
        this.entidadRepository = entidadRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.tipoContribuyenteRepository = tipoContribuyenteRepository;
    }

    public Entidad createEntidad(Entidad entidad) {
        // Add any business logic or validations before saving the entity
        return entidadRepository.save(entidad);
    }

    public Entidad getEntidadById(Long id) {
        return entidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidad not found with id: " + id));
    }

    public Entidad updateEntidad(Long id, Entidad entidad) {
        Entidad existingEntidad = entidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidad not found with id: " + id));

        existingEntidad.setTipoDocumento(entidad.getTipoDocumento());
        existingEntidad.setNumeroDocumento(entidad.getNumeroDocumento());
        existingEntidad.setRazonSocial(entidad.getRazonSocial());
        existingEntidad.setNombreComercial(entidad.getNombreComercial());
        existingEntidad.setTipoContribuyente(entidad.getTipoContribuyente());
        existingEntidad.setDireccion(entidad.getDireccion());
        existingEntidad.setTelefono(entidad.getTelefono());
        existingEntidad.setEstado(entidad.isEstado());

        return entidadRepository.save(existingEntidad);
    }
    public List<Entidad> getAllEntidades() {
        return entidadRepository.findAll();
    }

    public List<Entidad> getAllEntidadesWithNames() {
        return entidadRepository.findAllWithNames();
    }

    public Map<String, List<?>> getAllTipoDocumentoAndTipoContribuyente() {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAllByEstadoTrue();
        List<TipoContribuyente> tipoContribuyentes = tipoContribuyenteRepository.findAllByEstadoTrue();
        //List<Object[]> tipoDocumentos = tipoDocumentoRepository.findAllTipoDocumentos();
        //List<Object[]> tipoContribuyentes = tipoContribuyenteRepository.findAllTipoContribuyentes();

        System.out.println(tipoContribuyentes);
        System.out.println(tipoDocumentos);

        Map<String, List<?>> result = new HashMap<>();
        result.put("tipoDocumentos", tipoDocumentos);
        result.put("tipoContribuyentes", tipoContribuyentes);

        return result;
    }



    /*
    public List<TipoDocumentoContribuyenteDTO> getAllTipoDocumentoAndTipoContribuyente() {
        return entidadRepository.findAllTipoDocumentoAndTipoContribuyente();
    }
*/

    public void deleteEntidad(Long id) {
        entidadRepository.deleteById(id);
    }
}