package com.forms.backend.controllers.captura_relationVarWhitMDEA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;

import com.forms.backend.services.captura_relationVarWhitMDEA.RelationVarWhitMDEAService;

@RestController
@RequestMapping("/api/relacion-mdea")
public class RelationVarWhitMDEAController {

    @Autowired
    private RelationVarWhitMDEAService service;

    @PostMapping
    public RelationVarWhitMDEA crearRelacion(@RequestBody RelationVarWhitMDEA relation) {
        return service.save(relation);
    }

    @GetMapping("/{idVariableUnique}")
    public List<RelationVarWhitMDEA> getPorIdVariableUnique(@PathVariable Long idVariableUnique) {
        return service.getByVariableUnique(idVariableUnique);
    }

    @DeleteMapping("/{id}")
    public void eliminarRelacion(@PathVariable Long id) {
        service.deleteById(id);
    }
    
}
