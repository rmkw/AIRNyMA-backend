package com.forms.backend.repository.ods_pull;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.ods_pull.MetaId;
import com.forms.backend.entitys.ods_pull.meta_Enty;


public interface metaRepo extends JpaRepository<meta_Enty, MetaId> {
    List<meta_Enty> findByIdObjetivo(Integer idObjetivo);
}