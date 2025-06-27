package com.forms.backend.controllers.fuentes_identificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.fuentes_identificacion.CreateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.FuenteConConteoDTO;
import com.forms.backend.entitys.fuentes_identificacion.UpdateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import com.forms.backend.services.fuentes_identificacion.FiEconomicasCapService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fi-economicas")
public class FiEconomicasCapController {
     @Autowired
    private FiEconomicasCapService service;

    @GetMapping
    public List<fuentEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/fuente/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }


    @GetMapping("/{id_usuario}")
    public List<fuentEntity> getByUser(@PathVariable Integer id_usuario) {
        return service.getByUser(id_usuario);
    }

    @PostMapping
    public fuentEntity create(@RequestBody CreateFiEconomicasCapDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public fuentEntity update(@PathVariable Integer id, @RequestBody UpdateFiEconomicasCapDTO dto) {
        return service.update(id, dto);
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Map<String, Object>> deactivate(@PathVariable Integer id) {
        Map<String, Object> response = service.deactivateRecord(id);
        return ResponseEntity.ok(response);
    }
    
    // @GetMapping("/fuentes")
    // public ResponseEntity<?> getByacronimoAndResponsable(
    //         @RequestParam String acronimo,
    //         @RequestParam Integer responsableRegister) {

    //     List<fuentEntity> result = service.getByacronimoAndResponsable(acronimo, responsableRegister);

    //     return ResponseEntity.ok(Map.of(
    //             "message", "Registros encontrados",
    //             "fuentes", result));
    // }
    @GetMapping("/fuentes")
public ResponseEntity<?> getByacronimoAndResponsable(
        @RequestParam String acronimo,
        @RequestParam Integer responsableRegister) {

    List<FuenteConConteoDTO> result = service.getByacronimoAndResponsable(acronimo, responsableRegister);

    return ResponseEntity.ok(Map.of(
            "message", "Registros encontrados",
            "fuentes", result));
}


    @DeleteMapping("/{id}/delete-full")
    public ResponseEntity<Map<String, Object>> deleteFuenteCascade(@PathVariable Integer id) {
        Map<String, Object> result = service.deleteFuenteAndCascade(id);
        return ResponseEntity.ok(result);
    }

}
