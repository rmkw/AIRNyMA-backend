package com.forms.backend.repository.mdea.variablesMdea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.mdea.variablesMdea.MdeaVariablesEnty;

import java.util.List;

@Repository
public interface MdeaVariablesRepo extends JpaRepository<MdeaVariablesEnty, String> {

    List<MdeaVariablesEnty> findByIdCompAndIdSubAndIdTopOrderByUniqueId(Integer idComp, Integer idSub, Integer idTop);
}
