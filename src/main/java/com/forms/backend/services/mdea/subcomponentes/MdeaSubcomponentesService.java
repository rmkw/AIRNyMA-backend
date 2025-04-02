package com.forms.backend.services.mdea.subcomponentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.mdea.subcomponentes.MdeaSubcomponentesEnty;
import com.forms.backend.repository.mdea.subcomponentes.MdeaSubcomponentesRepo;

import java.util.List;

@Service
public class MdeaSubcomponentesService {
    @Autowired
    private MdeaSubcomponentesRepo repository;

    public List<MdeaSubcomponentesEnty> getSubcomponentesByCompId(Integer idComp) {
        return repository.findByIdComp(idComp);
    }
}
