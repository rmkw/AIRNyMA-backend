package com.forms.backend.repository.ods_pull;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.ods_pull.indic_Enty;
import com.forms.backend.entitys.ods_pull.IndicadorId;

public interface indicRepo extends JpaRepository<indic_Enty, IndicadorId> {
    List<indic_Enty> findByIdObjetivoAndIdMeta(Integer idObjetivo, String idMeta);
}
