package com.forms.backend.services.tema_cobertura_nece;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;
import com.forms.backend.repository.tema_cobertura_nece.TemaCobNecRepository;

@Service
public class TemaCobNecService {
    @Autowired
    private TemaCobNecRepository repository;

    public TemaCobNec guardar(TemaCobNec temaCobNec) {
        return repository.save(temaCobNec);
    }

    public Optional<TemaCobNec> buscarPorIdVariableUnique(Integer idVariableUnique) {
        return repository.findByIdVariableUnique(idVariableUnique);
    }
}
