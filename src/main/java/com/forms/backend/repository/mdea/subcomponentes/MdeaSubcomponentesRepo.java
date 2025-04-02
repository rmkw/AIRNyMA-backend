package com.forms.backend.repository.mdea.subcomponentes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.mdea.subcomponentes.MdeaSubcomponentesEnty;

import java.util.List;

@Repository
public interface MdeaSubcomponentesRepo extends JpaRepository<MdeaSubcomponentesEnty, Integer> {

    List<MdeaSubcomponentesEnty> findByIdComp(Integer idComp);
}