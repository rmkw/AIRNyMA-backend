package com.forms.backend.controllers.tema_cobertura_nece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;
import com.forms.backend.services.tema_cobertura_nece.TemaCobNecService;

@RestController
@RequestMapping("/api/tema-cob-nec")
public class TemaCobNecController {
    @Autowired
    private TemaCobNecService service;

    @PostMapping
    public ResponseEntity<TemaCobNec> crear(@RequestBody TemaCobNec temaCobNec) {
        TemaCobNec nuevo = service.guardar(temaCobNec);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/por-variable/{idVariableUnique}")
    public ResponseEntity<TemaCobNec> obtenerPorIdVariable(@PathVariable Integer idVariableUnique) {
        return service.buscarPorIdVariableUnique(idVariableUnique)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
