package com.forms.backend.repository.fuentes_identificacion;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import java.util.List;

@Repository
public interface FiEconomicasCapRepository extends JpaRepository<fuentEntity, Integer> {
    List<fuentEntity> findByResponsableRegisterOrderByIdFuenteAsc(Integer responsableRegister);
    
    List<fuentEntity> findAllByOrderByIdFuenteAsc();

    List<fuentEntity> findByResponsableRegisterAndIsactiveTrueOrderByIdFuenteAsc(Integer responsableRegister);

    List<fuentEntity> findByacronimoAndResponsableRegisterAndIsactiveTrue(String acronimo, Integer responsableRegister);

    @Query("SELECT f FROM fuentEntity f WHERE f.acronimo = :acronimo AND f.responsableRegister = :responsableRegister AND f.isactive = true ORDER BY CAST(f.anioEvento AS integer) DESC")
    List<fuentEntity> findByacronimoAndResponsableRegisterAndIsactiveTrueOrderByAnioEventoDesc(
            @Param("acronimo") String acronimo,
            @Param("responsableRegister") Integer responsableRegister
    );

    


}