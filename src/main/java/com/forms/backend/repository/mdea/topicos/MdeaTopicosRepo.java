package com.forms.backend.repository.mdea.topicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.mdea.topicos.MdeaTopicosEnty;

import java.util.List;

@Repository
public interface MdeaTopicosRepo extends JpaRepository<MdeaTopicosEnty, Integer> {

    List<MdeaTopicosEnty> findByIdCompAndIdSubOrderByUniqueId(Integer idComp, Integer idSub);
}