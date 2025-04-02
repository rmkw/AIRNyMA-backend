package com.forms.backend.controllers.mdea.vEstadisticosMdea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.mdea.vEstadisticosMdea.MdeaEstadisticosEnty;
import com.forms.backend.services.mdea.vEstadisticosMdea.MdeaEstadisticosService;

import java.util.List;

@RestController
@RequestMapping("/api/mdea/estadisticos")
public class MdeaEstadisticosController {
    @Autowired
    private MdeaEstadisticosService service;

    @GetMapping("/comp/{id_comp}/sub/{id_sub}/top/{id_top}/var/{id_var}")
    public ResponseEntity<List<MdeaEstadisticosEnty>> getEstadisticosByCompSubTopVar(
            @PathVariable Integer id_comp,
            @PathVariable Integer id_sub,
            @PathVariable Integer id_top,
            @PathVariable String id_var) {

        List<MdeaEstadisticosEnty> estadisticos = service.getEstadisticosByCompSubTopVar(id_comp, id_sub, id_top, id_var);
        if (estadisticos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadisticos);
    }
}
