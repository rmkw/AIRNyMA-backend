package com.forms.backend.controllers.ods_pull;
import java.util.List;
import com.forms.backend.entitys.ods_pull.indic_Enty;
import com.forms.backend.entitys.ods_pull.meta_Enty;
import com.forms.backend.entitys.ods_pull.objetivo_Enty;
import com.forms.backend.repository.ods_pull.indicRepo;
import com.forms.backend.repository.ods_pull.metaRepo;
import com.forms.backend.repository.ods_pull.objetivoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ods")
public class OdsController {
    @Autowired
    private objetivoRepo objetivoRepo;
    
    @Autowired
    private metaRepo metaRepo;
    
    @Autowired
    private indicRepo indicadorRepo;

    @GetMapping("/objetivos")
    public List<objetivo_Enty> getAllObjetivos() {
        return objetivoRepo.findAll();
    }

    @GetMapping("/metas/{idObjetivo}")
    public List<meta_Enty> getMetasByObjetivo(@PathVariable Integer idObjetivo) {
        return metaRepo.findByIdObjetivo(idObjetivo);
    }

    @GetMapping("/indicadores/{idObjetivo}/{idMeta}")
    public List<indic_Enty> getIndicadoresByMeta(
            @PathVariable("idObjetivo") Integer idObjetivo,
            @PathVariable String idMeta) {
        return indicadorRepo.findByIdObjetivoAndIdMeta(idObjetivo, idMeta);
    }
}
