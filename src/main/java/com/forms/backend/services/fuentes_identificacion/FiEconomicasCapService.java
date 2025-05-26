package com.forms.backend.services.fuentes_identificacion;


import com.forms.backend.entitys.fuentes_identificacion.CreateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.FuenteConConteoDTO;
import com.forms.backend.entitys.fuentes_identificacion.UpdateFiEconomicasCapDTO;
import com.forms.backend.entitys.fuentes_identificacion.fuentEntity;
import com.forms.backend.entitys.variables.VarEconomicasCap;
import com.forms.backend.repository.fuentes_identificacion.FiEconomicasCapRepository;

import com.forms.backend.repository.variables.RelationVarWhitMDEARepository;
import com.forms.backend.repository.variables.RelationVarWhit_ODSRepository;
import com.forms.backend.repository.variables.RelationVarWhit_TemaCobNecRepository;
import com.forms.backend.repository.variables.VarEconomicasCapRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FiEconomicasCapService {
    @Autowired
    private FiEconomicasCapRepository repository;

    @Autowired
    private VarEconomicasCapRepository VariableRepo;

    @Autowired
    private RelationVarWhit_TemaCobNecRepository TemaRepo;

    @Autowired
    private RelationVarWhitMDEARepository mdeaRepo;

    @Autowired
    private RelationVarWhit_ODSRepository odsRepo;
    





    public List<fuentEntity> getAll() {
        return repository.findAllByOrderByIdFuenteAsc();
    }

    public ResponseEntity<Map<String, Object>> getById(Integer id) {
    Optional<fuentEntity> optionalFuente = repository.findById(id);

    if (optionalFuente.isPresent()) {
        return ResponseEntity.ok(Map.of(
            "message", "Fuente encontrada",
            "fuente", optionalFuente.get()
        ));
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "message", "La fuente no existe"
        ));
    }
}

   

    public List<fuentEntity> getByUser(Integer idUsuario) {
        return repository.findByResponsableRegisterAndIsactiveTrueOrderByIdFuenteAsc(idUsuario);
    }

    public fuentEntity create(CreateFiEconomicasCapDTO dto) {
        fuentEntity entity = new fuentEntity();
        entity.setIdPp(dto.getIdPp());
        entity.setFuente(dto.getFuente());
        entity.setLinkFuente(dto.getLinkFuente());
        
        entity.setAnioEvento(dto.getAnioEvento());
        entity.setComentario(dto.getComentario());
        entity.setResponsableRegister(dto.getResponsableRegister());
        return repository.save(entity);
    }

    public fuentEntity update(Integer id, UpdateFiEconomicasCapDTO dto) {
        Optional<fuentEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            fuentEntity entity = optional.get();
            // entity.setIdPp(dto.getIdPp());
            entity.setFuente(dto.getFuente());
            entity.setLinkFuente(dto.getLinkFuente());
            // entity.setLinkAccesoFuente(dto.getLinkAccesoFuente());
            entity.setAnioEvento(dto.getAnioEvento());
            entity.setComentario(dto.getComentario());
            entity.setResponsableActualizacion(dto.getResponsableActualizacion());
            return repository.save(entity);
        }
        return null;
    }

    @Transactional
    public Map<String, Object> deactivateRecord(Integer id) {
        Optional<fuentEntity> optionalRecord = repository.findById(id);
        
        if (optionalRecord.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro no encontrado");
        }

        fuentEntity record = optionalRecord.get();
        if (!record.getIsactive()) {
            return Map.of("message", "El registro ya está desactivado");
        }

        record.setIsactive(false);
        repository.save(record);

        return Map.of(
            "message", "Registro desactivado correctamente",
            "id", record.getIdFuente()
        );
    }
    
    public List<FuenteConConteoDTO> getByIdPpAndResponsable(String idPp, Integer responsableRegister) {
    List<fuentEntity> fuentes = repository.findByIdPpAndResponsableRegisterAndIsactiveTrue(idPp, responsableRegister);

    return fuentes.stream().map(fuente -> {
        Long totalVariables = VariableRepo.countActiveVariablesByIdFuente(fuente.getIdFuente());
        return new FuenteConConteoDTO(
            fuente.getIdFuente(),
            fuente.getIdPp(),
            fuente.getFuente(),
            fuente.getLinkFuente(),
            fuente.getAnioEvento(),
            fuente.getComentario(),
            fuente.getIsactive(),
            fuente.getResponsableRegister(),
            fuente.getResponsableActualizacion(),
            totalVariables
        );
    }).toList();
}


    @Transactional
    public Map<String, Object> deleteFuenteAndCascade(Integer idFuente){
        Optional<fuentEntity> optionalRecord = repository.findById(idFuente);

        if (optionalRecord.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fuente no encontrada");
        }
        // Paso 1: Obtener las variables asociadas a esta fuente
    List<VarEconomicasCap> variables = VariableRepo.findByIdFuente(idFuente);

    // Paso 2: Por cada variable, eliminar relaciones y luego la variable
    for (VarEconomicasCap var : variables) {
        Integer varId = var.getIdUnique().intValue();;

        // Elimina temas de pertinencia
        TemaRepo.deleteByIdVariableUnique(varId);

        // Elimina ODS
        odsRepo.deleteByIdVariableUnique(varId);

        // Elimina MDEA
        mdeaRepo.deleteByIdVariableUnique(varId);

        // Elimina la variable
        VariableRepo.deleteById(Long.valueOf(varId));

    }

    // Paso 3: Elimina la fuente
    repository.deleteById(idFuente);

    return Map.of(
        "message", "Fuente y todas sus relaciones eliminadas correctamente",
        "id", idFuente
    );
    }

    
}
