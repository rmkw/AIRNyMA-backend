package com.forms.backend.repository.z_procesos_produccion;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO;
import com.forms.backend.entitys.z_procesos_produccion.z_procesos_produccion;

import jakarta.transaction.Transactional;



@Repository
public interface repo_procesosProduccion extends JpaRepository<z_procesos_produccion, String>{
   List<z_procesos_produccion> findByunidadIgnoreCase(String unidad);

   
   @Modifying
   @Transactional
   @Query("UPDATE z_procesos_produccion p SET p.comentarioS = :comentario WHERE p.acronimo = :acronimo")
   void actualizarComentarioPorAcronimo(@Param("acronimo") String acronimo, @Param("comentario") String comentario);

   List<z_procesos_produccion> findByIdUnidadOrderByAcronimoAsc(Integer idUnidad);

   @Query("""
               SELECT new com.forms.backend.entitys.z_procesos_produccion.ProcesoProduccionDTO(
                   p.acronimo, p.proceso, p.metodo, p.objetivo, p.pobjeto, p.uobservacion,
                   p.unidad, p.periodicidad, p.iin, p.estatus, p.comentarioS, p.comentarioA, p.idUnidad
               )
               FROM z_procesos_produccion p
               WHERE p.idUnidad = :idUnidad
               ORDER BY p.acronimo ASC
           """)
   List<ProcesoProduccionDTO> findProcesosConConteoVariablesByIdUnidad(@Param("idUnidad") Integer idUnidad);

}
