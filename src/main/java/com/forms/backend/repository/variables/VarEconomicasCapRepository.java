package com.forms.backend.repository.variables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.forms.backend.entitys.variables.VarEconomicasCap;

import java.util.List;

@Repository
public interface VarEconomicasCapRepository extends JpaRepository<VarEconomicasCap, Long> {
    List<VarEconomicasCap> findByIsActiveTrue();
    
    List<VarEconomicasCap> findByResponsableRegisterAndIdFuenteAndIsActiveTrue(
            Integer responsableRegister, Integer idFuente);
    
    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN true ELSE false END FROM VarEconomicasCap v WHERE v.idVariable = :idVariable AND v.idFuente = :idFuente")
    boolean existsByIdVariableAndIdFuente(@Param("idVariable") String idVariable, @Param("idFuente") Integer idFuente);

    List<VarEconomicasCap> findByIdVariable(String idVariable);

    void deleteByIdUnique(Long idUnique);

    List<VarEconomicasCap> findByIdFuente(Integer idFuente);

    // VarEconomicasCapRepository.java
    @Query("SELECT COUNT(v) FROM VarEconomicasCap v WHERE v.idFuente = :idFuente AND v.isActive = true")
    Long countActiveVariablesByIdFuente(@Param("idFuente") Integer idFuente);

    @Query("SELECT v FROM VarEconomicasCap v WHERE v.responsableRegister = :responsableRegister AND v.idFuente = :idFuente AND v.isActive = true ORDER BY v.idVariable ASC")
    List<VarEconomicasCap> findByResponsableRegisterAndIdFuenteAndIsActiveTrueOrderByIdVariable(
            @Param("responsableRegister") Integer responsableRegister,
            @Param("idFuente") Integer idFuente);

    




}
