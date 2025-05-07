package com.forms.backend.services.variables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.forms.backend.entitys.variables.VarEconomicasCap;

import com.forms.backend.repository.variables.VarEconomicasCapRepository;

import java.util.List;


@Service
public class VarEconomicasCapService {
    @Autowired
    private VarEconomicasCapRepository repository;

    

   

    

    public VarEconomicasCap crearVariable(VarEconomicasCap variable) {
        VarEconomicasCap nueva = repository.save(variable);
        System.out.println("Nuevo ID generado: " + nueva.getIdUnique());
        return nueva;
    }
    
    public List<VarEconomicasCap> getByResponsableAndFuente(Integer responsableRegister, Integer idFuente) {
        return repository.findByResponsableRegisterAndIdFuenteAndIsActiveTrue(responsableRegister, idFuente);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Variable no encontrada");
        }
        repository.deleteById(id);
    }

    public List<VarEconomicasCap> getByIdVariable(String idVariable) {
        return repository.findByIdVariable(idVariable);
    }
}
