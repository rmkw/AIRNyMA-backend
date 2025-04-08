package com.forms.backend.controllers.mdea.subcomponentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.mdea.subcomponentes.MdeaSubcomponentesEnty;
import com.forms.backend.services.mdea.subcomponentes.MdeaSubcomponentesService;
import java.util.List;

@RestController
@RequestMapping("/api/mdea/subcomponente")
public class MdeaSubcomponentesController {
    @Autowired
    private MdeaSubcomponentesService service;

    @GetMapping("/comp/{id_comp}")
    public ResponseEntity<List<MdeaSubcomponentesEnty>> getSubcomponentesByCompId(@PathVariable Integer id_comp) {
        List<MdeaSubcomponentesEnty> subcomponentes = service.getSubcomponentesByCompId(id_comp);
        if (subcomponentes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subcomponentes);
    }
}
