package primalcode.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primalcode.challenge.model.TipoContribuyente;
import primalcode.challenge.model.TipoDocumento;
import primalcode.challenge.service.TipoContribuyenteService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-contribuyente")
public class TipoContribuyenteController {

    private final TipoContribuyenteService tipoContribuyenteService;

    public TipoContribuyenteController(TipoContribuyenteService tipoContribuyenteService) {
        this.tipoContribuyenteService = tipoContribuyenteService;
    }

    @GetMapping
    public ResponseEntity<List<TipoContribuyente>> getAllTypeContributors() {
        List<TipoContribuyente> typecontributors = tipoContribuyenteService.getAllTipoContribuyentes();
        return ResponseEntity.ok(typecontributors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContribuyente> getTipoContribuyenteById(@PathVariable("id") Long id) {
        TipoContribuyente tipoContribuyente = tipoContribuyenteService.getTipoContribuyenteById(id);
        return ResponseEntity.ok(tipoContribuyente);
    }

    @PostMapping
    public ResponseEntity<TipoContribuyente> createTipoContribuyente(@RequestBody TipoContribuyente tipoContribuyente) {
        TipoContribuyente createdTipoContribuyente = tipoContribuyenteService.createTipoContribuyente(tipoContribuyente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoContribuyente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoContribuyente> updateTipoContribuyente(@PathVariable("id") Long id, @RequestBody TipoContribuyente tipoContribuyente) {
        TipoContribuyente updatedTipoContribuyente = tipoContribuyenteService.updateTipoContribuyente(id, tipoContribuyente);
        return ResponseEntity.ok(updatedTipoContribuyente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoContribuyente(@PathVariable("id") Long id) {
        tipoContribuyenteService.deleteTipoContribuyente(id);
        return ResponseEntity.noContent().build();
    }
}