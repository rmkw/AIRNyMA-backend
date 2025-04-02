package com.forms.backend.services.mdea.componente;


import org.springframework.stereotype.Service;

import com.forms.backend.entitys.mdea.componentes.MdeaComponentesEnty;
import com.forms.backend.repository.mdea.componentes.MdeaComponentesRepo;

import java.util.List;

@Service
public class MdeaComponentesService {
    private final MdeaComponentesRepo repository;

    public MdeaComponentesService(MdeaComponentesRepo repository) {
        this.repository = repository;
    }

    public List<MdeaComponentesEnty> obtenerTodos() {
        return repository.findAll();
    }
}
