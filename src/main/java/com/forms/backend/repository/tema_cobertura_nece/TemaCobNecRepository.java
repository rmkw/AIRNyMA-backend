package com.forms.backend.repository.tema_cobertura_nece;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;

public interface TemaCobNecRepository extends JpaRepository<TemaCobNec, Long> {
    Optional<TemaCobNec> findByIdVariableUnique(Integer idVariableUnique);
}
