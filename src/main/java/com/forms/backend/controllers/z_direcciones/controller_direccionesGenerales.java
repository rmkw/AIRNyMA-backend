package com.forms.backend.controllers.z_direcciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forms.backend.entitys.z_direcciones.Enty_direccionesGenerales;
import com.forms.backend.services.z_direcciones.service_direccionesGenerales;

@RestController
@RequestMapping("/api/direcciones")
public class controller_direccionesGenerales {
    @Autowired
    private service_direccionesGenerales service;

    @GetMapping
    public List<Enty_direccionesGenerales> getAllDirecciones(){
        return service.getAllDir();
    }
}
