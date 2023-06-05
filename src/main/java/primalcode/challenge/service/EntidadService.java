package primalcode.challenge.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.repository.EntidadRepository;

import java.util.List;

@Service
public class EntidadService {
    private final EntidadRepository entidadRepository;

    public EntidadService(EntidadRepository entidadRepository) {
        this.entidadRepository = entidadRepository;
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

    public void deleteEntidad(Long id) {
        entidadRepository.deleteById(id);
    }
}