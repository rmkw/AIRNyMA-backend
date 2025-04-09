package com.forms.backend.repository.ods_pull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.ods_pull.objetivo_Enty;

public interface objetivoRepo extends JpaRepository<objetivo_Enty, Integer> {
    // Todos los métodos básicos de CRUD ya están incluidos
}