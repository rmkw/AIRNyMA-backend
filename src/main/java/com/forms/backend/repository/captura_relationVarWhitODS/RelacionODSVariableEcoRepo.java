package com.forms.backend.repository.captura_relationVarWhitODS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;

public interface RelacionODSVariableEcoRepo extends JpaRepository<RelationVarWhit_ODS, Long> {
    List<RelationVarWhit_ODS> findByIdVariableUnique(Long idVariableUnique);
}