package primalcode.challenge.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import primalcode.challenge.model.TipoContribuyente;
import primalcode.challenge.repository.TipoContribuyenteRepository;

import java.util.List;

@Service
public class TipoContribuyenteService {
    private final TipoContribuyenteRepository tipoContribuyenteRepository;

    public TipoContribuyenteService(TipoContribuyenteRepository tipoContribuyenteRepository) {
        this.tipoContribuyenteRepository = tipoContribuyenteRepository;
    }

    public TipoContribuyente createTipoContribuyente(TipoContribuyente tipoContribuyente) {
        // Add any business logic or validations before saving the entity
        return tipoContribuyenteRepository.save(tipoContribuyente);
    }


    public TipoContribuyente getTipoContribuyenteById(Long id) {
        return tipoContribuyenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TipoContribuyente not found"));

    }

    public TipoContribuyente updateTipoContribuyente(Long id, TipoContribuyente tipoContribuyente) {
        TipoContribuyente existingTipoContribuyente = tipoContribuyenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TipoContribuyente not found with id: " + id));
        existingTipoContribuyente.setNombre(tipoContribuyente.getNombre());
        existingTipoContribuyente.setEstado(tipoContribuyente.isEstado());

        return tipoContribuyenteRepository.save(existingTipoContribuyente);
    }
    public List<TipoContribuyente> getAllTipoContribuyentes() {
        return tipoContribuyenteRepository.findAll();
    }

    public void deleteTipoContribuyente(Long id) {
        tipoContribuyenteRepository.deleteById(id);
    }

    // Add any other methods or business logic as needed
}