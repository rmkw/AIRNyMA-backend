package com.forms.backend.repository.variables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.variables.VarEconomicasCap;

import java.util.List;

@Repository
public interface VarEconomicasCapRepository extends JpaRepository<VarEconomicasCap, Long> {
    List<VarEconomicasCap> findByIsActiveTrue();
    
}
