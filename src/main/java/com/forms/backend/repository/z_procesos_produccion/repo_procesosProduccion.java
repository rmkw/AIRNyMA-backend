package com.forms.backend.repository.z_procesos_produccion;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO;
import com.forms.backend.entitys.z_procesos_produccion.z_procesos_produccion;



@Repository
public interface repo_procesosProduccion extends JpaRepository<z_procesos_produccion, Integer>{
   List<z_procesos_produccion> findByUnidadAdministrativaIgnoreCase(String unidadAdministrativa);

   
   @Modifying
   @Query("UPDATE z_procesos_produccion p SET p.comentarioPp = :comentario WHERE p.id = :id")
   void actualizarComentarioPorId(@Param("id") Integer id, @Param("comentario") String comentario);

   List<z_procesos_produccion> findByIdUnidadOrderByAcronimoAsc(Integer idUnidad);

   @Query("""
             SELECT new com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO(
                 p.id, p.programaInformacion, p.acronimo, p.nombreProceso,
                 p.clavePeriodicidadProceso, p.periodicidadProceso, p.inicioVigencia, p.conclusion,
                 p.objetivo, p.poblacionObjeto, p.unidadObservacion, p.unidadAdministrativa,
                 p.claveMetodoGeneracion, p.metodoGeneracion, p.coberturaTematica, p.coberturaGeografica,
                 p.productos, p.clavePeriodicidadProductos, p.periodicidadProductos,
                 p.claveGradoMadurez, p.gradoMadurez, p.claveIin, p.condicionIin,
                 p.fechaDeterminacionIin, p.clavePeriodicidadCambios, p.periodicidadCambios,
                 p.claveOrigenRecursos, p.origenRecursos, p.claveDga, p.dgaResponsable,
                 p.fechaIncorporacion, p.claveCondicionInfraestructura, p.condicionInfraestructura,
                 p.claveInfraestructura, p.infraestructura, p.estatus, p.idUnidad, p.comentarioPp,
                 (SELECT COUNT(v) FROM VarEconomicasCap v WHERE v.idPp = p.acronimo)
             )
             FROM z_procesos_produccion p
             WHERE p.idUnidad = :idUnidad
             ORDER BY p.acronimo ASC
         """)
   List<ProcesoProduccionDTO> findProcesosConConteoVariablesByIdUnidad(@Param("idUnidad") Integer idUnidad);

}
