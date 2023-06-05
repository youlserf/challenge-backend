package primalcode.challenge.service;

import jakarta.persistence.EntityNotFoundException;

import primalcode.challenge.model.TipoDocumento;
import primalcode.challenge.repository.TipoDocumentoRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public TipoDocumento createTipoDocumento(TipoDocumento tipoDocumento) {
        // Add any business logic or validations before saving the entity
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    public TipoDocumento getTipoDocumentoById(Long id) {
        return tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TipoDocumento not found"));
    }

    public List<TipoDocumento> getAllTipoDocumentos() {
        return tipoDocumentoRepository.findAll();
    }

    public TipoDocumento updateTipoDocumento(Long id, TipoDocumento tipoDocumento) {
        TipoDocumento existingTipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TipoDocumento not found with id: " + id));

        existingTipoDocumento.setCodigo(tipoDocumento.getCodigo());
        existingTipoDocumento.setNombre(tipoDocumento.getNombre());
        existingTipoDocumento.setDescripcion(tipoDocumento.getDescripcion());
        existingTipoDocumento.setEstado(tipoDocumento.isEstado());

        return tipoDocumentoRepository.save(existingTipoDocumento);
    }

    public void deleteTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }

    // Add any other methods or business logic as needed
}