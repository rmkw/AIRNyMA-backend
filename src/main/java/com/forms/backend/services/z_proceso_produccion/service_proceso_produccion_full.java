package com.forms.backend.services.z_proceso_produccion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.z_procesos_produccion.proceso_produccion_FULL;
import com.forms.backend.repository.z_proceso_produccion.proceso_produccion_Full_repo;

@Service
public class service_proceso_produccion_full {
    @Autowired
    private proceso_produccion_Full_repo procesoRepo;
    
    public List<proceso_produccion_FULL> getAllProceso_produccion_FULLs(){
        return procesoRepo.findAll();
    }
}
