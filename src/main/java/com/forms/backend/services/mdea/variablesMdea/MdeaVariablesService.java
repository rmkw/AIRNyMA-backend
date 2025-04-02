package com.forms.backend.services.mdea.variablesMdea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.mdea.variablesMdea.MdeaVariablesEnty;
import com.forms.backend.repository.mdea.variablesMdea.MdeaVariablesRepo;

import java.util.List;

@Service
public class MdeaVariablesService {
    @Autowired
    private MdeaVariablesRepo repository;

    public List<MdeaVariablesEnty> getVariablesByCompSubTop(Integer idComp, Integer idSub, Integer idTop) {
        return repository.findByIdCompAndIdSubAndIdTopOrderByUniqueId(idComp, idSub, idTop);
    }
}
