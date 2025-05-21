package com.forms.backend.repository.z_procesos_produccion;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.z_procesos_produccion.z_procesos_produccion;



@Repository
public interface repo_procesosProduccion extends JpaRepository<z_procesos_produccion, Integer>{
   List<z_procesos_produccion> findByUnidadAdministrativaIgnoreCase(String unidadAdministrativa);

   
   @Modifying
   @Query("UPDATE z_procesos_produccion p SET p.comentarioPp = :comentario WHERE p.id = :id")
   void actualizarComentarioPorId(@Param("id") Integer id, @Param("comentario") String comentario);

   List<z_procesos_produccion> findByIdUnidadOrderByAcronimoAsc(Integer idUnidad);

}
