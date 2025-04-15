package com.forms.backend.services.captura_relationVarWhitMDEA;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;
import com.forms.backend.repository.captura_relationVarWhitMDEA.RelationVarWhitMDEARepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationVarWhitMDEAService {

    @Autowired
    private RelationVarWhitMDEARepo repository;

    public RelationVarWhitMDEA save(RelationVarWhitMDEA relation) {
        return repository.save(relation);
    }

    public List<RelationVarWhitMDEA> getByVariableUnique(Long idVariableUnique) {
        return repository.findByIdVariableUnique(idVariableUnique);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
