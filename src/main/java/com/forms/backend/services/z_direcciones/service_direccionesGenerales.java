package com.forms.backend.services.z_direcciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.z_direcciones.Enty_direccionesGenerales;
import com.forms.backend.repository.z_direcciones.repo_direccionesGenerales;

@Service
public class service_direccionesGenerales {

    @Autowired
    private repo_direccionesGenerales repo;

    public List<Enty_direccionesGenerales> getAllDir(){
        return repo.findAll(Sort.by("idDi"));
    }
}
