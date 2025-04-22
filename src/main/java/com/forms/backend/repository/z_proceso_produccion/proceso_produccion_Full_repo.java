package com.forms.backend.repository.z_proceso_produccion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.z_procesos_produccion.proceso_produccion_FULL;

public interface proceso_produccion_Full_repo extends JpaRepository<proceso_produccion_FULL, Long>{
    
}
