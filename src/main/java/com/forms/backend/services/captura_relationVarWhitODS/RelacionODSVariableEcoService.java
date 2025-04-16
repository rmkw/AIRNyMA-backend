package com.forms.backend.services.captura_relationVarWhitODS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;
import com.forms.backend.repository.captura_relationVarWhitODS.RelacionODSVariableEcoRepo;

@Service
public class RelacionODSVariableEcoService {
    @Autowired
    private RelacionODSVariableEcoRepo repository;

    public RelationVarWhit_ODS save(RelationVarWhit_ODS relacion) {
        return repository.save(relacion);
    }

    public List<RelationVarWhit_ODS> getByIdVariableUnique(Long idVariableUnique) {
        return repository.findByIdVariableUnique(idVariableUnique);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
