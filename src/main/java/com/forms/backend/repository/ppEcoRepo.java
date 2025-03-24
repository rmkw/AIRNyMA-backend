package com.forms.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;

import com.forms.backend.entitys.ppEcoDTO;

public interface ppEcoRepo extends JpaRepository<ppEcoDTO, Long> {

    Optional<ppEcoDTO> findByAcronimoProceso(String acronimoProceso);

    @NonNull
    List<ppEcoDTO> findAll(@NonNull Sort sort);
}
