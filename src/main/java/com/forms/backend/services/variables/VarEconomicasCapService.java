package com.forms.backend.services.variables;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.forms.backend.entitys.captura_relationVarWhitMDEA.RelationVarWhitMDEA;
import com.forms.backend.entitys.captura_relationVarWhitODS.RelationVarWhit_ODS;
import com.forms.backend.entitys.tema_cobertura_nece.TemaCobNec;
import com.forms.backend.entitys.variables.VarEconomicasCap;
import com.forms.backend.entitys.variables.VaryRelationsDTO;

import com.forms.backend.repository.variables.RelationVarWhitMDEARepository;
import com.forms.backend.repository.variables.RelationVarWhit_ODSRepository;
import com.forms.backend.repository.variables.RelationVarWhit_TemaCobNecRepository;
import com.forms.backend.repository.variables.VarEconomicasCapRepository;



import java.util.List;

import java.util.stream.Collectors;


@Service
public class VarEconomicasCapService {
    @Autowired
    private VarEconomicasCapRepository repository;
    @Autowired
    private RelationVarWhitMDEARepository mdeaRepository;
    @Autowired
    private RelationVarWhit_ODSRepository odsRepository;
    @Autowired
    private RelationVarWhit_TemaCobNecRepository pertinenciaRepository;


    

   

    

    public VarEconomicasCap crearVariable(VarEconomicasCap variable) {
        // Validación manual antes de guardar
        if (repository.existsByIdVariableAndIdFuente(variable.getIdVariable(), variable.getIdFuente())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe una variable con ese ID y fuente");
        }

        try {
            VarEconomicasCap nueva = repository.save(variable);
            System.out.println("Nuevo ID generado: " + nueva.getIdVariableCaracterizada());
            return nueva;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Conflicto al guardar la variable (posible duplicado)", e);
        }
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

    public List<VaryRelationsDTO> getWithRelationsByIdVariable(String idVariable) {
    List<VarEconomicasCap> variables = repository.findByIdVariable(idVariable);

    return variables.stream().map(var -> {
        VaryRelationsDTO dto = new VaryRelationsDTO();
        // Copia atributos básicos
        BeanUtils.copyProperties(var, dto);

        // Agrega relaciones
        List<RelationVarWhitMDEA> mdeas = mdeaRepository.findByIdVariableUnique(var.getIdVariableCaracterizada());
        List<RelationVarWhit_ODS> ods = odsRepository.findByIdVariableUnique(var.getIdVariableCaracterizada());
        List<TemaCobNec> pertinencia = pertinenciaRepository.findByIdVariableUnique(var.getIdVariableCaracterizada());
        dto.setPertinencia(pertinencia);

        dto.setMdeas(mdeas);
        dto.setOds(ods);
        return dto;
        }).collect(Collectors.toList());
    }

    public List<VarEconomicasCap> getByResponsableAndFuente(Integer responsableRegister, Integer idFuente) {
        return repository.findByResponsableRegisterAndIdFuenteAndIsActiveTrueOrderByIdVariable(responsableRegister,
                idFuente);
    }

    


       

}
