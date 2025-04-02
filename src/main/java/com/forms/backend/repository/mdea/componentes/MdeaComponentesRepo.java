package com.forms.backend.repository.mdea.componentes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forms.backend.entitys.mdea.componentes.MdeaComponentesEnty;

@Repository
public interface MdeaComponentesRepo extends JpaRepository<MdeaComponentesEnty, Long> {
    
}
