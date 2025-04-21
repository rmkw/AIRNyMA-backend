package com.forms.backend.controllers.variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.variables.VarEconomicasCap;
import com.forms.backend.entitys.variables.VarEconomicasCapDTO;
import com.forms.backend.services.variables.VarEconomicasCapService;

import java.util.List;

@RestController
@RequestMapping("/api/variables")
public class VarEconomicasCapController {
     @Autowired
    private VarEconomicasCapService service;

    @GetMapping
    public List<VarEconomicasCapDTO> getAllActive() {
        return service.getAllActive();
    }

    @PostMapping
    public VarEconomicasCapDTO create(@RequestBody VarEconomicasCapDTO dto) {
        return service.create(dto);
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

}
