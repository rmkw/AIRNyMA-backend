package com.forms.backend.controllers.captura_relationVarWhitODS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;
import com.forms.backend.services.captura_relationVarWhitODS.RelacionODSVariableEcoService;

@RestController
@RequestMapping("/api/relacion-ods")
public class RelacionODSVariableEcoController {
    @Autowired
    private RelacionODSVariableEcoService service;

    @PostMapping
    public RelationVarWhit_ODS crearRelacion(@RequestBody RelationVarWhit_ODS relacion) {
        return service.save(relacion);
    }

    @GetMapping("/{idVariableUnique}")
    public List<RelationVarWhit_ODS> obtenerPorIdVariableUnique(@PathVariable Long idVariableUnique) {
        return service.getByIdVariableUnique(idVariableUnique);
    }

    @DeleteMapping("/{id}")
    public void eliminarRelacion(@PathVariable Long id) {
        service.deleteById(id);
    }
}
