package com.forms.backend.controllers.mdea.topico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.forms.backend.entitys.mdea.topicos.MdeaTopicosEnty;
import com.forms.backend.services.mdea.topico.MdeaTopicosService;
import java.util.List;

@RestController
@RequestMapping("/api/mdea/topicos")
public class MdeaTopicosController {
    @Autowired
    private MdeaTopicosService service;

    @GetMapping("/comp/{id_comp}/sub/{id_sub}")
    public ResponseEntity<List<MdeaTopicosEnty>> getTopicosByCompAndSub(
            @PathVariable Integer id_comp,
            @PathVariable Integer id_sub) {

        List<MdeaTopicosEnty> topicos = service.getTopicosByCompAndSub(id_comp, id_sub);
        if (topicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topicos);
    }
}
