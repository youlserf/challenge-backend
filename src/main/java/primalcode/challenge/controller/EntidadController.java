package primalcode.challenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primalcode.challenge.model.Entidad;
import primalcode.challenge.model.TipoDocumentoContribuyenteDTO;
import primalcode.challenge.service.EntidadService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {

    private final EntidadService entidadService;

    public EntidadController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }
    @GetMapping
    public ResponseEntity<List<Entidad>> getAllEntities() {
        List<Entidad> entidades = entidadService.getAllEntidadesWithNames();
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("/docont")
    public ResponseEntity<Map<String, List<?>>> getAllTipoDocumentoAndTipoContribuyente() {
        Map<String, List<?>> tipoDocumentoAndTipoContribuyente = entidadService.getAllTipoDocumentoAndTipoContribuyente();
        return ResponseEntity.ok(tipoDocumentoAndTipoContribuyente);
    }



/*
    @GetMapping("/docont")
    public ResponseEntity<List<TipoDocumentoContribuyenteDTO>> getAllTipoDocumentoAndTipoContribuyente() {
        System.out.println("here we are my friend");
        List<TipoDocumentoContribuyenteDTO> entidades = entidadService.getAllTipoDocumentoAndTipoContribuyente();
        System.out.println(entidades);
        System.out.println("here we are my friend");
        return ResponseEntity.ok(entidades);
    }
 */
    @GetMapping("/{id}")
    public ResponseEntity<Entidad> getEntidadById(@PathVariable("id") Long id) {
        Entidad entidad = entidadService.getEntidadById(id);
        return ResponseEntity.ok(entidad);
    }

    @PostMapping
    public ResponseEntity<Entidad> createEntidad(@RequestBody Entidad entidad) {
        Entidad createdEntidad = entidadService.createEntidad(entidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entidad> updateEntidad(@PathVariable("id") Long id, @RequestBody Entidad entidad) {
        Entidad updatedEntidad = entidadService.updateEntidad(id, entidad);
        return ResponseEntity.ok(updatedEntidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntidad(@PathVariable("id") Long id) {
        entidadService.deleteEntidad(id);
        return ResponseEntity.noContent().build();
    }
}
