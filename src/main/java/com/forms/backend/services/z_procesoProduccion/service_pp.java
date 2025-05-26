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

    public List<z_procesos_produccion> obtenerPorUnidadAdministrativa(String unidadAdministrativa){
        return repo.findByUnidadAdministrativaIgnoreCase(unidadAdministrativa);
    }

    @Transactional
    public void actualizarComentario(Integer id, String comentario) {
        repo.actualizarComentarioPorId(id, comentario);
    }

    public List<ProcesoProduccionDTO> obtenerPorIdUnidadConConteo(Integer idUnidad) {
        return repo.findProcesosConConteoVariablesByIdUnidad(idUnidad);
    }


}
