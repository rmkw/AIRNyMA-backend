package com.forms.backend.controllers.mdea.variablesMdea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.mdea.variablesMdea.MdeaVariablesEnty;
import com.forms.backend.services.mdea.variablesMdea.MdeaVariablesService;

import java.util.List;

@RestController
@RequestMapping("/api/mdea/variables")
public class MdeaVariablesController {
    @Autowired
    private MdeaVariablesService service;

    @GetMapping("/comp/{id_comp}/sub/{id_sub}/top/{id_top}")
    public ResponseEntity<List<MdeaVariablesEnty>> getVariablesByCompSubTop(
            @PathVariable Integer id_comp,
            @PathVariable Integer id_sub,
            @PathVariable Integer id_top) {

        List<MdeaVariablesEnty> variables = service.getVariablesByCompSubTop(id_comp, id_sub, id_top);
        if (variables.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(variables);
    }
}
