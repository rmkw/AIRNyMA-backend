package com.forms.backend.repository.fuentes_identificacion;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import java.util.List;

@Repository
public interface FiEconomicasCapRepository extends JpaRepository<fuentEntity, Integer> {
    List<fuentEntity> findByResponsableRegisterOrderByIdFuenteAsc(Integer responsableRegister);
    
    List<fuentEntity> findAllByOrderByIdFuenteAsc();
}