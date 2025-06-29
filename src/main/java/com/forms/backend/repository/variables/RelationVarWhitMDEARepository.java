package com.forms.backend.repository.variables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;

public interface RelationVarWhitMDEARepository extends JpaRepository<RelationVarWhitMDEA, Long> {
    List<RelationVarWhitMDEA> findByIdVariableUnique(String idVariableCaracterizada);

    void deleteByIdVariableUnique(String idUnique);
    
}
