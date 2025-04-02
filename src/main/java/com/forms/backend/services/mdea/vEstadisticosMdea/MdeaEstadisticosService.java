package com.forms.backend.services.mdea.vEstadisticosMdea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.mdea.vEstadisticosMdea.MdeaEstadisticosEnty;
import com.forms.backend.repository.mdea.vEstadisticosMdea.MdeaEstadisticosRepo;

import java.util.List;

@Service
public class MdeaEstadisticosService {
    @Autowired
    private MdeaEstadisticosRepo repository;

    public List<MdeaEstadisticosEnty> getEstadisticosByCompSubTopVar(
            Integer idComp, Integer idSub, Integer idTop, String idVar) {
        return repository.findByIdCompAndIdSubAndIdTopAndIdVarOrderByUniqueId(idComp, idSub, idTop, idVar);
    }
}
