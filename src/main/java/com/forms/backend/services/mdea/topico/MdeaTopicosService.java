package com.forms.backend.services.mdea.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.mdea.topicos.MdeaTopicosEnty;
import com.forms.backend.repository.mdea.topicos.MdeaTopicosRepo;

import java.util.List;

@Service
public class MdeaTopicosService {
    @Autowired
    private MdeaTopicosRepo repository;

    public List<MdeaTopicosEnty> getTopicosByCompAndSub(Integer idComp, Integer idSub) {
        return repository.findByIdCompAndIdSubOrderByUniqueId(idComp, idSub);
    }
}
