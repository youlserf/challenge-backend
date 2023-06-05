package primalcode.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.model.TipoDocumento;
import primalcode.challenge.service.TipoDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-documento")
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
    @GetMapping
    public ResponseEntity<List<TipoDocumento>> getAllTypedocuments() {
        List<TipoDocumento> typedocuments = tipoDocumentoService.getAllTipoDocumentos();
        return ResponseEntity.ok(typedocuments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable("id") Long id) {
        TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(id);
        return ResponseEntity.ok(tipoDocumento);
    }

    @PostMapping
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento createdTipoDocumento = tipoDocumentoService.createTipoDocumento(tipoDocumento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable("id") Long id, @RequestBody TipoDocumento tipoDocumento) {
        TipoDocumento updatedTipoDocumento = tipoDocumentoService.updateTipoDocumento(id, tipoDocumento);
        return ResponseEntity.ok(updatedTipoDocumento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable("id") Long id) {
        tipoDocumentoService.deleteTipoDocumento(id);
        return ResponseEntity.noContent().build();
    }
}