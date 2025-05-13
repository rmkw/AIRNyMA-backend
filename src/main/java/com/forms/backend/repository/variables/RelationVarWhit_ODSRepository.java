package com.forms.backend.repository.variables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;

public interface RelationVarWhit_ODSRepository extends JpaRepository<RelationVarWhit_ODS, Long> {
    List<RelationVarWhit_ODS> findByIdVariableUnique(Long idVariableUnique);
    
}
