package com.forms.backend.controllers.mdea.componentes;

import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.mdea.componentes.MdeaComponentesEnty;
import com.forms.backend.services.mdea.componente.MdeaComponentesService;

import java.util.List;

@RestController
@RequestMapping("/api/mdea/componentes")
public class MdeaComponentesController {
    private final MdeaComponentesService service;

    public MdeaComponentesController(MdeaComponentesService service) {
        this.service = service;
    }

    @GetMapping
    public List<MdeaComponentesEnty> obtenerTodos() {
        return service.obtenerTodos();
    }
}
