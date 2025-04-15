package com.forms.backend.repository.captura_relationVarWhitMDEA;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;

import java.util.List;

@Repository

public interface RelationVarWhitMDEARepo  extends JpaRepository<RelationVarWhitMDEA, Long> {
    List<RelationVarWhitMDEA> findByIdVariableUnique(Long idVariableUnique);
}