package com.forms.backend.services.z_procesoProduccion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO;
import com.forms.backend.entitys.z_procesos_produccion.z_procesos_produccion;
import com.forms.backend.repository.z_procesos_produccion.repo_procesosProduccion;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class service_pp {
    private final repo_procesosProduccion repo;

    public List<z_procesos_produccion> obtenerTodos(){
        return repo.findAll();
    }

    public List<z_procesos_produccion> obtenerPorunidad(String unidad){
        return repo.findByunidadIgnoreCase(unidad);
    }

    @Transactional
    public void actualizarComentario(String acronimo, String comentario) {
        repo.actualizarComentarioPorAcronimo(acronimo, comentario);
    }

    public List<ProcesoProduccionDTO> obtenerPorIdUnidadConConteo(Integer idUnidad) {
        return repo.findProcesosConConteoVariablesByIdUnidad(idUnidad);
    }


}
