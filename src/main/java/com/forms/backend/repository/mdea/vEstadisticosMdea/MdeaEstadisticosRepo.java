package com.forms.backend.repository.mdea.vEstadisticosMdea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.mdea.vEstadisticosMdea.MdeaEstadisticosEnty;

import java.util.List;

@Repository
public interface MdeaEstadisticosRepo extends JpaRepository<MdeaEstadisticosEnty, String> {

    List<MdeaEstadisticosEnty> findByIdCompAndIdSubAndIdTopAndIdVarOrderByUniqueId(
            Integer idComp, Integer idSub, Integer idTop, String idVar);
}
