package com.forms.backend.controllers.variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.variables.VarEconomicasCap;

import com.forms.backend.services.variables.VarEconomicasCapService;


import java.util.List;


@RestController
@RequestMapping("/api/variables")
public class VarEconomicasCapController {
     @Autowired
    private VarEconomicasCapService service;

    @PostMapping
    public ResponseEntity<VarEconomicasCap> crearVariable(@RequestBody VarEconomicasCap variable) {
        VarEconomicasCap nueva = service.crearVariable(variable);
        return ResponseEntity.ok(nueva);
    }

    // Endpoint con PathVariables
    @GetMapping("/filtered/{responsableRegister}/{idFuente}")
    public List<VarEconomicasCap> getByResponsableAndFuente(
            @PathVariable Integer responsableRegister,
            @PathVariable Integer idFuente) {
        
        return service.getByResponsableAndFuente(responsableRegister, idFuente);
    }

    @DeleteMapping("/{id}")
    public void deleteVariable(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/por-id/{idVariable}")
    public List<VarEconomicasCap> getByIdVariable(@PathVariable String idVariable) {
        return service.getByIdVariable(idVariable);
    }

}
