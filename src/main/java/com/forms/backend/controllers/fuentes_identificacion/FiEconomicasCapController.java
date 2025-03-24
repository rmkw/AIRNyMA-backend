package com.forms.backend.controllers.fuentes_identificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.fuentes_identificacion.CreateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.UpdateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import com.forms.backend.services.fuentes_identificacion.FiEconomicasCapService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fi-economicas")
public class FiEconomicasCapController {
     @Autowired
    private FiEconomicasCapService service;

    @GetMapping
    public List<fuentEntity> getAll() {
        return service.getAll();
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
}
