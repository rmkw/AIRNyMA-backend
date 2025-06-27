package com.forms.backend.repository.variables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;

public interface RelationVarWhit_TemaCobNecRepository extends JpaRepository<TemaCobNec, Long>{
    List<TemaCobNec> findByIdVariableUnique(String idVariableCaracterizada);

    void deleteByIdVariableUnique(String idUnique);
}
